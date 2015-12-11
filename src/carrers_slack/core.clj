(ns carrers-slack.core
  (:gen-class)
  (:require
    [carrers-slack.slack-notification :as slack]))

(defn -main
  ""
  [users-channel & admins-channel]
  (println (slack/notify-users users-channel (first admins-channel))))
