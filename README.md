# carrers-slack

FIXME: description

## Installation

Download from http://example.com/FIXME.

## Usage

1. Input your Slack token (which you can find at the [Slack Web API page](https://api.slack.com/web) on line 7 of `src/slack-notifier.clj`
2. Input your message (which will be the link to the survey, or whatever) on line 29
3. Build a jar with `lein uberjar`
4. Wait 700 hours while everything fails to be fetched from Clojars because the wifi at the cafe you're at sucks (that's what you get for being a hipster and going to NYC)
5. Celebrate once it builds. No don't get drunk. You can do that after the next step
6. `java -jar target/uberjar/carrers-slack-0.1.0-SNAPSHOT-standalone.jar [args]`, where your first arg is the channel you want to spam, and the second is a channel containing people you don't want to spam
7. Find out it doesn't work for groups
8. Try to make it work for groups, and discover clj-slack doesn't have "groups.info"
9. Your installation of Leiningen doesn't work because of some obscure nREPL bug
10. Weep

## Options

FIXME: listing of options this app accepts.

## Examples

...

### Bugs

...

### Any Other Sections
### That You Think
### Might be Useful

## License

Copyright © 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
