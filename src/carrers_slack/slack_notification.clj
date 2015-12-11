(ns carrers-slack.slack-notification
  (:require
    [clj-slack.channels :as channels]
    [clj-slack.users :as users]
    [clj-slack.chat :as chat]))

(def token "xoxp-2302734798-4573835662-15961974736-ee2974f9ec")
(def connection  {:api-url "https://slack.com/api" :token token})

(def channel-list
  (:channels (channels/list connection)))

(defn channel->code [channel]
  (:id (first (filter #(= channel (:name %)) channel-list))))

(defn channel-users [channel]
  (let [channel-code (channel->code channel)
        channel-info (channels/info connection channel-code)]
    (get-in channel-info [:channel :members])))

(defn slackable-users [channel exclusion-channel]
  (let [users (set (channel-users channel))
        admin-users (if exclusion-channel (set (channel-users exclusion-channel)) #{})]
    (clojure.set/difference users admin-users)))


(defn notify-users [channel exclusion-channel]
  (map
   #(chat/post-message connection % "Hello")
   (slackable-users channel exclusion-channel)))

