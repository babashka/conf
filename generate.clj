#!/usr/bin/env bb

(require '[clojure.edn :as edn]
         '[hiccup.core :as hiccup])

(defn convert-to-html
  [site]
  (spit
    "index.html"
    (->> "data.edn"
         slurp
         edn/read-string
         site
         (hiccup/html)
         (str "<!DOCTYPE html>"))))

(defn hr []
  [:hr.mx-auto.my-20.lg:my-20])

(def intro
  [:div.mt-10
   [:p.text-xl.mt-4 "Welcome to the first ever conference dedicated to Babashka! It will not only be about showcasing the latest advancements and use cases of Babashka, but also about celebrating the community that has formed around it."]])


(def call-for-proposals
  [:h3.text-2xl.mt-4 "Want to contribute a talk or a workshop? Great – we'd love to hear from you."
   [:div.mt-10
    [:p.text-xl.my-4 "To submit a proposal, send us an email at "
     [:a.my-auto.hover:underline
      {:href "mailto:babashka.conf@gmail.com"} "babashka.conf@gmail.com"]
     ". Your proposal doesn't have to be long. Include just enough information for us to be able to judge whether the talk would be a good fit."]
    [:h4.text-xl.font-medium.mt-4 "Talks"
     [:ul.text-lg.list-disc.list-inside
      [:li "20 min of speaking time (plus 10 min Q&A) - as Clojurists, we like conciseness in our talks as well as in our language."]
      [:li "Topics include Babashka and related topics at all skill levels (beginner-level talks are welcome as well as expert topics). We want to hear what’s exciting to you!"]
      [:li "Looking for inspiration on writing a proposal? Check out the great "
       [:a.my-auto.hover:underline
        {:href "https://blog.cssconf.eu/2014/06/12/how-to-write-a-great-talk-proposal-for-a-tech-conference/"}
        "CSSConf guide"]]]]
    [:h4.text-xl.font-medium.mt-4 "Workshops"
     [:ul.text-lg.list-disc.list-inside
      [:li "You've got 90 minutes total for you workshop"]
      [:li "Try to add some slack time for Q&A"]
      [:li "Topics include all things related to babashka and the wider ecosystem"]
      [:li "Please mention the level of prior knowledge required"]
      [:li "Is a notebook needed to attend to your workshop?"]]]
    [:h4.text-xl.font-medium.mt-4 "Your proposal should include the following:"
     [:ul.text-lg.list-disc.list-inside
      [:li "A pithy title"]
      [:li "An abstract (1500 characters max)"]
      [:li "A short author bio (600 characters max)"]
      [:li "Contact information (email address and optionally Clojurians slack handle and Twitter handle)"]
      [:li "Optionally links to additional material (github projects, previous presentations)"]]]
    [:p.text-lg.font-bold.my-4 "As a free conference, babashka-conf won’t be able to pay travel or accommodation for speakers."]
    [:p.text-xl.my-4
     "The call for proposals is open until " [:a.font-semibold "May 10, 2023"] ". We will notify speakers on May 17. If you have any questions about the CfP, don't hesitate to reach out at "
     [:a.my-auto.hover:underline
      {:href "mailto:babashka.conf@gmail.com"} "babashka.conf@gmail.com"]
     "."]
    [:p.text-xl.my-4 "If you're unsure whether your topic fits babashka-conf, we encourage you to submit your proposal or to email us. In good Clojure conference tradition, we're curious about lots of things in adjacent fields, including Clojure community, software engineering practices, diversity, industry experience reports, devops etc."]]])

(defn site
  [_]
  [:html
   [:head
    [:meta {:charset "UTF-8"}]
    [:title "babashka-conf"]
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
    [:link {:rel "stylesheet" :href "https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"}]
    [:link {:rel "stylesheet" :href "https://cdnjs.cloudflare.com/ajax/libs/prism/1.23.0/themes/prism-solarizedlight.min.css"}]
    ;; note, upgrading to tailwind 2.2.12 breaks the layout!
    [:link {:href "https://unpkg.com/tailwindcss@2.2.10/dist/tailwind.min.css" :rel "stylesheet"}]
    [:link {:href "https://fonts.gstatic.com" :rel "preconnect"}]
    [:link {:rel "stylesheet" :href "https://fonts.googleapis.com/css2?family=Forum&family=Raleway:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"}]
    [:script {:src "https://cdnjs.cloudflare.com/ajax/libs/prism/1.23.0/prism.min.js" :defer true}]
    [:script {:src "https://cdnjs.cloudflare.com/ajax/libs/prism/1.23.0/plugins/autoloader/prism-autoloader.min.js" :defer true}]]


   [:body.overflow-x-hidden {:style "font-family: 'Raleway', sans-serif;"}
    [:div.absolute {:style "width: 180vw; height: 200vh; background: linear-gradient(90deg, #B70000,rgba(227, 30, 37, 0.5) 50%, rgba(255, 255, 255, 0.1)); transform: rotateZ(-35deg) translate(-130vw, -150vh);"}]
    [:header.w-full.shadow-md.relative.bg-white {:style "box-shadow: 0 4px 10px 0 rgba(0, 0, 0, 0.05);"}
     [:div.container.h-auto.mx-auto.grid.grid-cols-1.py-6.lg:grid-flow-col.lg:auto-cols-max
      [:h1.text-lg.mb-5.mx-auto.lg:mx-0.lg:mb-auto.col-end-auto
       [:img {:src "./assets/babashka.svg"
              :width "200px"}]]

      [:nav.flex.flex-row.flex-nowrap.mb-5.lg:mb-0.mx-auto
       [:a.my-auto.mx-2.sm:mx-10.hover:underline {:href ""} "TODO: Tickets"]]
      [:nav.flex.flex-row.flex-nowrap.mb-5.lg:mb-0.mx-auto
       [:a.my-auto.mx-2.sm:mx-10.hover:underline {:href ""} "TODO: Buy Merch"]]
      [:nav.flex.flex-row.flex-nowrap.mb-5.lg:mb-0.mx-auto
       [:a.my-auto.mx-2.sm:mx-10.hover:underline {:href "https://goo.gl/maps/9KHpcXevvvFJbe5M8"} "Venue"]]

      [:nav.flex.flex-row.flex-nowrap.mx-auto
       [:a.my-auto.mx-5 {:href "https://app.slack.com/client/T03RZGPFR/C04VAK5U86L"}
        [:img {:src "./assets/slack.svg"
               :width "33x"}]]
       [:a.my-auto.mx-5 {:href "https://twitter.com/search?q=%23babashka%20OR%20babashka&src=typed_query&f=live"}
        [:img {:src "./assets/twitter.svg"}]]]]]

    [:main.relative.px-10.pt-24.md:px-32.md:pt-32.lg:px-80.lg:pt-60
     [:section
      [:h2.text-6xl {:style "font-family: Forum, serif;"} "1st babashka-conf in Berlin"]
      [:br]
      [:p.text-4xl.text-center {:style "font-family: Forum, serif;"} "10th June 2023"]
      intro]

     (hr)

     [:section
      [:h2.text-4xl {:style "font-family: Forum, serif;"} "Call for Proposals"]
      [:div.mb-6 call-for-proposals]] 

     (hr)

     [:section
      [:div.text-5xl.my-4 {:style "font-family: Forum, serif;"} [:a {:href "https://pitch.com/"} "Thank you to Pitch"]]
      [:div "Thank you to our friends at Pitch for providing the venue."]]

     (hr)

     [:footer.footer-1.py-8.sm:py-12
      "Credits: initial site design by Alice Kile."]
     ,]]])


(convert-to-html site)
