#!/usr/bin/env bb

(require '[clojure.edn :as edn]
         '[hiccup.core :as hiccup])

(defn convert-to-html
  [index schedule]
  (spit
   "schedule.html"
   (->> "data.edn"
        slurp
        edn/read-string
        schedule
        (hiccup/html)
        (str "<!DOCTYPE html>")))
  (spit
   "index.html"
   (->> "data.edn"
        slurp
        edn/read-string
        index
        (hiccup/html)
        (str "<!DOCTYPE html>"))))

(defn hr []
  [:hr.mx-auto.my-20.lg:my-20])

(defn head [content]
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
    [:script {:src "https://cdnjs.cloudflare.com/ajax/libs/prism/1.23.0/plugins/autoloader/prism-autoloader.min.js" :defer true}]
    [:style "
.abstract {
   font-size: 10pt;
}
.bio {
   font-size: 10pt;
   font-style: italic;
}
"]]

   [:header.overflow-x-hidden {:style "font-family: 'Raleway', sans-serif;"}
    [:div.absolute {:style "width: 180vw; height: 200vh; background: linear-gradient(90deg, #B70000,rgba(227, 30, 37, 0.5) 50%, rgba(255, 255, 255, 0.1)); transform: rotateZ(-35deg) translate(-130vw, -150vh);"}]
    [:header.w-full.shadow-md.relative.bg-white {:style "box-shadow: 0 4px 10px 0 rgba(0, 0, 0, 0.05);"}
     [:div.container.h-auto.mx-auto.grid.grid-cols-1.py-6.lg:grid-flow-col.lg:auto-cols-max
      [:h1.text-lg.mb-5.mx-auto.lg:mx-0.lg:mb-auto.col-end-auto
       [:a {:href "index.html"}
        [:img {:src "./assets/babashka.svg"
               :alt "Babashka Logo"
               :width "200px"}]]]

      [:nav.flex.flex-row.flex-nowrap.mb-5.lg:mb-0.mx-auto
       [:a.my-auto.mx-2.sm:mx-5.hover:underline {:href "https://www.meetup.com/clojure-berlin/events/292998496/"} "Tickets"]]
      [:nav.flex.flex-row.flex-nowrap.mb-5.lg:mb-0.mx-auto
       [:a.my-auto.mx-2.sm:mx-5.hover:underline {:href "schedule.html"} "Schedule"]]
      [:nav.flex.flex-row.flex-nowrap.mb-5.lg:mb-0.mx-auto
       [:a.my-auto.mx-2.sm:mx-5.hover:underline {:href "https://www.etsy.com/listing/1475981599/babashka-conf-berlin-2023-t-shirt"} "T-shirt"]]
      [:nav.flex.flex-row.flex-nowrap.mb-5.lg:mb-0.mx-auto
       [:a.my-auto.mx-2.sm:mx-5.hover:underline {:href "https://goo.gl/maps/9KHpcXevvvFJbe5M8"} "Venue"]]

      [:nav.flex.flex-row.flex-nowrap.mx-auto
       [:a.my-auto.mx-5 {:href "https://app.slack.com/client/T03RZGPFR/C04VAK5U86L"}
        [:img {:src "./assets/slack.svg"
               :width "33x"}]]
       [:a.my-auto.mx-5 {:href "https://twitter.com/search?q=%23babashka%20OR%20babashka&src=typed_query&f=live"}
        [:img {:src "./assets/twitter.svg"}]]]]]]
   content])

(def intro
  [:div.mt-10
   [:p.text-xl.mt-4 "Welcome to the first ever conference dedicated to Babashka! It will not only be about showcasing the latest advancements and use cases of Babashka, but also about celebrating the community that has formed around it."]])

(def announcements
  [:section
   [:h2.text-4xl {:style "font-family: Forum, serif;"} "Announcements"]
   [:p.text-xl.mt-4 "We have now published " [:a.my-auto.hover:underline {:href "schedule.html"} "the schedule"] ". More details about the talks will be added soon."]
   [:br]
   [:p.text-xl.mt-4 "We're excited to announce that Michiel Borkent (" [:a.my-auto.hover:underline {:href "https://twitter.com/borkdude"} "@borkdude"] ") the author of Babashka, will be joining us as a keynote speaker. He is also a mastermind behind clj-kondo, SCI, and cherry. With his commitment to open source tools Michiel is a well respected and influential member of the Clojure community. Don't miss out on this incredible chance to hear from him at our conference!"]])

(defn index
  [_]
  (head
   [:main.relative.px-10.pt-24.md:px-32.md:pt-32.lg:px-80.lg:pt-60
    [:section
     [:h2.text-6xl.text-center {:style "font-family: Forum, serif;"} "1st babashka-conf in Berlin"]
     [:br]
     [:p.text-4xl.text-center {:style "font-family: Forum, serif;"} "10th June 2023"]
     intro]

    (hr)

    announcements

    (hr)

    [:section
     [:div.text-4xl.py-6 {:style "font-family: Forum, serif;"} "Thank you very much to our Sponsors"]
     [:div.py-6 {:style "font-family: Forum, serif;"}
      [:a {:href "https://pitch.com"}
       [:span.hidden "Pitch"]
       [:svg.object-none.w-48 {:fill "currentColor" :viewBox "0 0 66 23"}
        [:path {:d "M44.87 17.272a4.318 4.318 0 11.04-4.877l3.191-1.884a8.019 8.019 0 10-.017 8.613l-3.213-1.852zM53.662 0H49.96v22.206h3.7v-7.402a4.318 4.318 0 118.636 0v7.402h3.701v-8.122a7.3 7.3 0 00-12.336-5.282V0zM27.756 0h-3.701v17.271a5.551 5.551 0 009.201 4.183l-1.788-3.034a1.847 1.847 0 01-1.45.701h-.412a1.851 1.851 0 01-1.85-1.85v-6.168h3.7V7.402h-3.7V0zM19.74 0a2.056 2.056 0 100 4.112 2.056 2.056 0 000-4.112zM21.59 22.206V7.402h-3.7v14.804h3.7z" :fill "currentColor"}]
        [:path {:clip-rule "evenodd" :d "M0 22.206h3.7v-4.318h3.393A8.944 8.944 0 107.093 0H0v22.206zM3.7 3.7h3.393a5.243 5.243 0 010 10.486H3.701V3.7z" :fill-rule "evenodd" :fill "currentColor"}]]]]
     [:div.py-6 {:style "font-family: Forum, serif;"}
      [:a {:href "https://doctronic.de/"}
       [:img.w-96 {:style "transform-origin: top left; transform: scale(1.3);" :src "./assets/doctronic-logo.png" :alt "doctronic"}]]]
     [:div.py-6 {:style "font-family: Forum, serif;"}
      [:a {:href "https://www.scarletcomply.com/"}
       [:img {:style "transform-origin: top left; transform: scale(2.3);" :src "./assets/scarlet_logo.svg" :alt "scarlet comply"}]]]
     [:div.py-6 {:style "font-family: Forum, serif;"}
      [:a {:href "https://www.juxt.pro/"}
       [:img {:style "transform-origin: top left; transform: scale(0.4);" :src "./assets/juxt-logo.svg" :alt "JUXT Ltd"}]]]]

    (hr)

    [:footer.footer-1.py-8.sm:py-12
     "Credits: initial site design by Alice Kile."]]))

(defn schedule
  [_]
  (head
   [:main.relative.px-10.pt-24.md:px-32.md:pt-32.lg:px-80.lg:pt-60
    [:section
     [:h2.text-6xl.text-center {:style "font-family: Forum, serif;"} "Schedule"]]

    (hr)

    [:h3.text-4xl.pb-2 {:style "font-family: Forum, serif;"} "Saturday, 10th June 2023"]
    [:br]
    [:table.table-fixed.border-collapse.border-slate-400.w-full
     [:tbody.text-xl
      [:tr
       [:td.border.border-slate-300.h-14.pl-2 {:class "w-1/3"} "9:00"] [:td.border.border-slate-300.pl-2 "Doors open"]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2 {:class "w-1/3"} "9:30"] [:td.border.border-slate-300.pl-2 "Welcome"]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2 {:class "w-1/3"} "9:40"] [:td.border.border-slate-300.pl-2 "Clojure on SCIs"
                                                                        [:br]
                                                                        [:span.text-base "Malcolm Sparks"]
                                                                        [:br]
                                                                        [:span.font-medium.text-sm "40 min"]
                                                                        [:p.abstract "In the past few years I've been developing a secure durable programmable system, called Site. The language of this system is SCI, the small-clojure-interpreter that powers babashka. In this talk I'll explain some of the notable features and benefits of this system, for example, how state updates are made by submitting database transactions (to XTDB) written as SCI code. I'll explain why I chose SCI and some of the reasons SCI makes a perfect scripting language to embed in a JVM-based application, providing some tips along the way to others who want to try using SCI in this way."]
                                                                        [:p.bio "Malcolm is a Clojure developer with a keen interest in software architecture and API security. He is the co-founder and CTO of JUXT, a Clojure consulting firm."]]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2 {:class "w-1/3"} "10:20"] [:td.border.border-slate-300.pl-2 "Break"]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2 {:class "w-1/3"} "10:40"] [:td.border.border-slate-300.pl-2 "Portuguese Driving Schools and bb"
                                                                         [:br]
                                                                         [:span.text-base "Flavio Sousa"]
                                                                         [:br]
                                                                         [:span.font-medium.text-sm "30 min"]
                                                                         [:p.abstract "In this talk, I'll show how Babashka is powering a no-frills not-for-profit initiative attempting to bring a much-needed layer of transparency to a traditional business, deemed too unsexy to disrupt. I'll explain how Babashka brings Clojure and sanity to the messy realities of web and PDF scraping and how it enables a low budget and performant \"serverless\" solution, reminiscent of simpler times in web development.\n\nJoin me for a potpourri of state bureaucracy, freedom of information acts, incomprehensible stubbornness and low budget solutions that steer away from big tech."]
                                                                         [:p.bio "Flavio received a Master's in mechanical engineering from the University of Lisbon in 2010, where he worked for a Fluid Simulation Lab and published a couple of research papers. In 2013, he joined the booming Lisbon startup scene and fell in love with software development. Went to London in 2015 and has been working with Clojure pretty much ever since.\nFlavio's favorite book is Gödel, Escher, Bach, which made me realize just how amazing it is that we can actually use human language to tell machines what to do. Competed in Brazilian Jiu Jitsu until an injury put a stop to that, so now he just dances Brazilian Forró on the weekends."]]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2 {:class "w-1/3"} "11:20"] [:td.border.border-slate-300.pl-2 "SCI for Science"
                                                                         [:br]
                                                                         [:span.text-base "Daniel Slutsky"]
                                                                         [:br]
                                                                         [:span.font-medium.text-sm "30 min"]]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2 {:class "w-1/3"} "11:50"] [:td.border.border-slate-300.pl-2 "Lunch (we'll go out, bring cash)"]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2 {:class "w-1/3"} "13:30"] [:td.border.border-slate-300.pl-2 "Lightning talks"
                                                                         [:br]
                                                                         [:span.text-base "sign up on the day - 5 min each"]
                                                                         [:br]
                                                                         [:span.font-medium.text-sm "30 min"]]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2 {:class "w-1/3"} "14:10"] [:td.border.border-slate-300.pl-2 "Do or do not Clojure"
                                                                         [:br]
                                                                         [:span.text-base "Gert Goet"]
                                                                         [:br]
                                                                         [:span.font-medium.text-sm "30 min"]]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2 {:class "w-1/3"} "14:50"] [:td.border.border-slate-300.pl-2 "Don't forget the REPL"
                                                                         [:br]
                                                                         [:span.text-base "Martin Kavalar"]
                                                                         [:br]
                                                                         [:span.font-medium.text-sm "30 min"]]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2 {:class "w-1/3"} "15:20"] [:td.border.border-slate-300.pl-2 "Break"
                                                                         [:br]
                                                                         [:span.font-medium.text-sm "20 min"]]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2 {:class "w-1/3"} "15:40"] [:td.border.border-slate-300.pl-2 "Birds of Feather"
                                                                         [:br]
                                                                         [:span.text-base "We will break into smaller groups to discuss topics of interest"]
                                                                         [:br]
                                                                         [:span.font-medium.text-sm "50 min"]]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2 {:class "w-1/3"} "16:40"] [:td.border.border-slate-300.pl-2 "Build Your Own Little Memex with Babashka"
                                                                         [:br]
                                                                         [:span.text-base "Teodor Heggelund"]
                                                                         [:br]
                                                                         [:span.font-medium.text-sm "30 min"]]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2 {:class "w-1/3"} "17:20"] [:td.border.border-slate-300.pl-2 "Growing An Ecosystem"
                                                                         [:br]
                                                                         [:span.text-base "Michiel Borkent"]
                                                                         [:br]
                                                                         [:span.font-medium.text-sm "40 min"]]]]]

    (hr)

    [:footer.footer-1.py-8.sm:py-12
     "Credits: initial site design by Alice Kile."]]))

(convert-to-html index schedule)
