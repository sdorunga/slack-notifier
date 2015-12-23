(ns carrers-slack.slack-notification
  (:require
    [clj-slack.channels :as channels]
    [clj-slack.groups :as groups]
    [clj-slack.users :as users]
    [clj-slack.chat :as chat]
    [clj-slack.core :refer [slack-request stringify-keys]])
    (:refer-clojure :exclude [list]))


(def token "xxxxredacted")
(def connection  {:api-url "https://slack.com/api" :token token})

(def channel-list
  (:channels (channels/list connection)))

(def group-list
  (:groups (groups/list connection)))

(defn channel->code [channel]
  (:id (first (filter #(= channel (:name %)) channel-list))))

(defn group->code [group]
  (:id (first (filter #(= group (:name %)) group-list))))

(defn channel-users [channel]
  (let [channel-code (channel->code channel)
        channel-info (channels/info connection channel-code)]
    (get-in channel-info [:channel :members])))

(defn groups-info
  [connection group-id]
    (slack-request connection "groups.info" {"group" group-id}))

(defn group-users [group]
  (let [group-code (group->code group)
        group-info (groups-info connection group-code)]
    (get-in group-info [:group :members])))

(defn slackable-users [channel exclusion-channel]
  (let [users (set (channel-users channel))
        admin-users (if exclusion-channel (set (channel-users exclusion-channel)) #{})]
    (clojure.set/difference users admin-users)))

(defn slackable-group-users [group exclusion-group]
  (let [users (set (group-users group))
        admin-users (if exclusion-group (set (group-users exclusion-group)) #{})]
    (clojure.set/difference users admin-users)))

(defn notify-users [channel exclusion-channel]
  (map
   #(chat/post-message connection % "It's time for the weekly jobhunter survey! Please take a minute or two to fill out the form: https://makersacademy.typeform.com/to/xf5Lpj")
   (slackable-group-users channel exclusion-channel)))

