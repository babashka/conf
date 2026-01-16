#!/usr/bin/env bb

(require '[clojure.edn :as edn]
         '[hiccup2.core :as hiccup])

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
    [:link {:rel "stylesheet" :href "https://cdn.jsdelivr.net/npm/water.css@2/out/water.css"}]
    [:link {:rel "stylesheet" :href "https://cdnjs.cloudflare.com/ajax/libs/prism/1.23.0/themes/prism-solarizedlight.min.css"}]
    [:link {:href "https://fonts.gstatic.com" :rel "preconnect"}]
    [:link {:rel "stylesheet" :href "https://fonts.googleapis.com/css2?family=Forum&family=Raleway:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"}]
    [:script {:src "https://cdnjs.cloudflare.com/ajax/libs/prism/1.23.0/prism.min.js" :defer true}]
    [:script {:src "https://cdnjs.cloudflare.com/ajax/libs/prism/1.23.0/plugins/autoloader/prism-autoloader.min.js" :defer true}]
    [:style "
.abstract {
   font-size: 10pt;
}
.bio {
   margin-top: 10px;
   font-size: 10pt;
   font-style: italic;
}
header {
  text-align: center;
  margin-bottom: 2rem;
}
header img {
  margin: 0 auto 1rem;
}
nav {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 1.5rem;
  margin: 1rem 0;
}
"]]

   [:header
    [:a {:href "index.html"}
     [:img {:src "./assets/babashka.svg"
            :alt "Babashka Logo"
            :width "200px"}]]
    [:nav
     [:a {:href "https://www.meetup.com/the-dutch-clojure-meetup/events/312079164"} "Tickets"]
     #_[:a {:href "schedule.html"} "Schedule"]
     [:a {:href "https://www.etsy.com/listing/1475981599/babashka-conf-berlin-2023-t-shirt"} "T-shirt"]
     [:a {:href "https://maps.app.goo.gl/xqVZA57sfqHiXkb87"} "Venue"]
     [:a {:href "https://app.slack.com/client/T03RZGPFR/C04VAK5U86L"} "Slack"]]]
   content])

(def intro
  [:div
   [:section
    [:div.mt-10
     [:h2.text-4xl {:style "font-family: Forum, serif;"} "Babashka conf returns"]
     [:p.text-xl.mt-4 "Babaxshka-conf returns! Like last time in Berlin 2023, it will not only be about showcasing the latest advancements and use cases of Babashka, but also about adjacent technologies and celebrating the community that has formed around babashka."]
     [:p.text-xl.mt-4 "Make sure to get your ticket at "[:a {:href "https://www.meetup.com/the-dutch-clojure-meetup/events/312079164/"} "meetup.com"] " while they are still available."]]]
   [:section
    [:p.text-xl.mt-4 "Babashka-conf is organized the day before " [:a {:href "https://clojuredays.org/"} "Dutch Clojure Days 2026"] " so you can have two days of Clojure fun in and around Amsterdam!"]
    [:p.text-xl.mt-4 "Keep an eye on this website as it will up be updated in the coming months. CfP starts mid January when the CfP of DCD26 closes."]
    [:p.text-xl.mt-4 "In case of questions, you can reach us at " [:a {:href "mailto:babashka.conf@gmail.com"} "babashka.conf@gmail.com."] " and in the " [:a {:href "https://app.slack.com/client/T03RZGPFR/C04VAK5U86L"} "#babashka-conf Slack channel."]]
    [:p.text-xl.mt-4 "We are looking for sponsors. More information about this will be posted on this website, but if you are eager to sponsor, you can already reach out to us."]
    [:p.text-xl.mt-4 "You can expect some community-organized activities before and after the conference, information about this will be posted in the Slack channel."]]])

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
     [:h2.text-6xl.text-center {:style "font-family: Forum, serif;"} "Babashka-conf returns, this time in Amsterdam NL!"]
     [:br]
     [:p.text-4xl.text-center {:style "font-family: Forum, serif;"} "8th of May 2026, 13:00-17:00, OBA Oosterdok, Oosterdokskade 143, 1011DL Amsterdam (OBA Congres, 6th floor)"]
     intro]

    #_(hr)

    announcements

    (hr)

    [:section
     [:div.text-4xl.py-6 {:style "font-family: Forum, serif;"} "Thank you very much to our Platinum Sponsors"]
     [:div.py-6 {:style "font-family: Forum, serif;"}
      [:a {:href "https://exoscale.com"}
       [:img {:src "./assets/exoscale-logo.png" :alt "Exoscale"
              :width "300px"}]]]
     [:div.py-6 {:style "font-family: Forum, serif;"}
      [:a {:href "https://github.com/bobisageek"}
       [:img {:src "./assets/bob.png" :alt "Bob"
              :width "300px"}]]]
     #_[:div.py-6 {:style "font-family: Forum, serif;"}
      [:a {:href "https://doctronic.de/"}
       [:img.w-96 {:style "transform-origin: top left; transform: scale(1.3);" :src "./assets/doctronic-logo.png" :alt "doctronic"}]]]
     #_[:div.py-6 {:style "font-family: Forum, serif;"}
      [:a {:href "https://www.scarletcomply.com/"}
       [:img {:style "transform-origin: top left; transform: scale(2.3);" :src "./assets/scarlet_logo.svg" :alt "scarlet comply"}]]]
     #_[:div.py-6 {:style "font-family: Forum, serif;"}
      [:a {:href "https://www.juxt.pro/"}
       [:img {:style "transform-origin: top left; transform: scale(0.4);" :src "./assets/juxt-logo.svg" :alt "JUXT Ltd"}]]]]

    (hr)

    [:footer.footer-1.py-8.sm:py-12
     "Credits: initial site design by Alice Kile."]]))

(defn abstract [txt]
  [:details
   [:summary [:span.text-base "Abstract"]]
   [:p.abstract txt]])

(defn bio [txt]
  [:details
   [:summary [:span.text-base "Bio"]]
   [:p.bio txt]])

(defn schedule
  [_]
  (head
   [:main.relative.px-10.pt-24.md:px-32.md:pt-32.lg:px-80.lg:pt-60
    [:section
     [:h2.text-6xl.text-center {:style "font-family: Forum, serif;"} "Schedule"]]

    (hr)

    [:h3.text-4xl.pb-2 {:style "font-family: Forum, serif;"} "Friday, 9th June 2023"]
    [:p.text-xl.mt-4 "19:00 Pre-conference beers at Alte Turnhalle, Holteistraße 6-9, 10245 Berlin"]
    [:br]
    [:h3.text-4xl.pb-2 {:style "font-family: Forum, serif;"} "Saturday, 10th June 2023"]
    [:br]
    [:table.table-fixed.border-collapse.border-slate-400.w-full
     [:tbody.text-xl
      [:tr
       [:td.border.border-slate-300.h-14.pl-2.align-top {:class "w-1/3"} "9:00"] [:td.border.border-slate-300.pl-2 "Doors open"]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2.align-top {:class "w-1/3"} "9:30"] [:td.border.border-slate-300.pl-2 "️Welcome"]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2.align-top {:class "w-1/3"} "9:40"] [:td.border.border-slate-300.pl-2 "Clojure on SCIs (Opening Keynote)"
                                                                                  [:br]
                                                                                  [:span.text-base "Malcolm Sparks"]
                                                                                  [:br]
                                                                                  [:span.font-medium.text-sm "40 min"]
                                                                                  (abstract "In the past few years I've been developing a secure durable programmable system, called Site. The language of this system is SCI, the small-clojure-interpreter that powers babashka. In this talk I'll explain some of the notable features and benefits of this system, for example, how state updates are made by submitting database transactions (to XTDB) written as SCI code. I'll explain why I chose SCI and some of the reasons SCI makes a perfect scripting language to embed in a JVM-based application, providing some tips along the way to others who want to try using SCI in this way.")
                                                                                  (bio "Malcolm is a Clojure developer with a keen interest in software architecture and API security. He is the co-founder and CTO of JUXT, a Clojure consulting firm.")]
       [:tr
        [:td.border.border-slate-300.h-14.pl-2.align-top {:class "w-1/3"} "10:20"] [:td.border.border-slate-300.pl-2 "☕️☕Break☕☕"]]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2.align-top {:class "w-1/3"} "10:40"] [:td.border.border-slate-300.pl-2 "Portuguese Driving Schools and Babashka"
                                                                                   [:br]
                                                                                   [:span.text-base "Flavio Sousa"]
                                                                                   [:br]
                                                                                   [:span.font-medium.text-sm "30 min"]
                                                                                   (abstract "In this talk, I'll show how Babashka is powering a no-frills not-for-profit initiative attempting to bring a much-needed layer of transparency to a traditional business, deemed too unsexy to disrupt. I'll explain how Babashka brings Clojure and sanity to the messy realities of web and PDF scraping and how it enables a low budget and performant \"serverless\" solution, reminiscent of simpler times in web development.\n\nJoin me for a potpourri of state bureaucracy, freedom of information acts, incomprehensible stubbornness and low budget solutions that steer away from big tech.")
                                                                                   (bio "Flavio received a Master's in mechanical engineering from the University of Lisbon in 2010, where he worked for a Fluid Simulation Lab and published a couple of research papers. In 2013, he joined the booming Lisbon startup scene and fell in love with software development. Went to London in 2015 and has been working with Clojure pretty much ever since.\nFlavio's favorite book is Gödel, Escher, Bach, which made me realize just how amazing it is that we can actually use human language to tell machines what to do. Competed in Brazilian Jiu Jitsu until an injury put a stop to that, so now he just dances Brazilian Forró on the weekends.")]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2.align-top {:class "w-1/3"} "11:20"] [:td.border.border-slate-300.pl-2 "SCI for Science"
                                                                                   [:br]
                                                                                   [:span.text-base "Daniel Slutsky"]
                                                                                   [:br]
                                                                                   [:span.font-medium.text-sm "30 min"]
                                                                                   (abstract "Scientific computing workflows typically require a balance between dynamic playfulness and stable reproducibility. \n\nOne way to seek such balance is the \"namespace as a notebook\" approach: enjoying the playfulness of the Clojure editor and REPL in a self-documenting fashion, generating a document as a side-effect. This has been manifested in different ways through the evolution of tools such as Oz, Notespace, Clerk, and Clay. \n\nOf all the above, Clay intentionally tries to be the least clever, offering a minimalistic approach targeting documents such as HTML files, Quarto pages, and reveal.js presentations. These documents can include interactive widgets and access various data visualization libraries using SCI (through Scittle).\n\nIn this talk, we will explore a real-world data-science problem using Clay, focusing on usability and the desired workflow.\nOur perspective will be the Scicloj journey to make Clojure a friendly option for people tackling data and science problems. We will discuss the role of SCI in the solution, as well as some of the technical and conceptual challenges on that path.\n\nBasic knowledge of Clojure will be assumed.")
                                                                                   (bio "Daniel Slutsky is a mathematician and a data scientist who has been using Clojure since 2013.\nIn his professional path, Daniel has primarily worked in data science and backend teams at startups, addressing diverse topics such as time-series analysis, recommendation systems, geospatial analysis, and NLP.\nHis MSc thesis was in pure math around topics of probability theory.\nDaniel is a community organizer at the Scicloj community, building a Clojure stack for data science and running various Clojure study groups and dev groups. His approach towards community building and teaching is drawn from his experience as a community organizer in various local activist groups and his yoga instructor training.\nHe has been co-maintaining several Clojure open-source projects, particularly Clojisr, Notespace, Kindly, and Clay.")]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2.align-top {:class "w-1/3"} "11:50"] [:td.border.border-slate-300.pl-2 "🥗🥗Lunch (we'll go out, bring cash)🥗🥗"]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2.align-top {:class "w-1/3"} "13:30"] [:td.border.border-slate-300.pl-2 "⚡⚡️Lightning talks⚡⚡"
                                                                                   [:br]
                                                                                   [:span.text-base "sign up on the day - 5 min each"]
                                                                                   [:br]
                                                                                   [:span.font-medium.text-sm "30 min"]]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2.align-top {:class "w-1/3"} "14:10"] [:td.border.border-slate-300.pl-2 "Do or Do Not Clojure"
                                                                                   [:br]
                                                                                   [:span.text-base "Gert Goet"]
                                                                                   [:br]
                                                                                   [:span.font-medium.text-sm "30 min"]
                                                                                   (abstract "When was the last time you ran into a new library and thought: “If only I could give it a spin real quick…”? It’s this friction that deps-try tries to remove.\nAnd it shouldn’t matter whether the thing you want to try is a published library, a git-repository, a local project or just Clojure itself: you’ll spin up a rebel-readline powered REPL just as easily.\n\nIn this talk you’ll learn all about deps-try, how it aims to make Clojure more accessible to newcomers and how Babashka makes it all tick.")
                                                                                   (bio "Gert is an independent consultant with over 15 years of experience building backends and tooling.\n\nWhile currently being on the lookout for a new Clojure project (are you using Clojure to improve the world? Let’s talk!), he’s co-organising the Aarhus Clojure-meetup, maintaining the Clojure event calendar, learning Danish and\nwriting open-source software. Currently his focus is on deps-try, a CLI-tool that aims to make it convenient to explore Clojure (or any library) from the REPL.")]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2.align-top {:class "w-1/3"} "14:50"] [:td.border.border-slate-300.pl-2 "Don't Forget the REPL"
                                                                                   [:br]
                                                                                   [:span.text-base "Martin Kavalar"]
                                                                                   [:br]
                                                                                   [:span.font-medium.text-sm "30 min"]
                                                                                   (abstract "Babashka's instant startup time makes it a great choice for scripting. This can make it tempting to iterate by re-running scripts. This talk is a reminder that Babashka has good support for interactive development with the REPL.\n\nWe'll explore when you should consider reaching for the REPL. We hope you'll learn a few tricks about REPL-driven development in general and in Babashka in particular.")
                                                                                   (bio "Martin Kavalar is a co-founder at Nextjournal, a hybrid between startup and research lab trying to improve programming. Nextjournal makes a polyglot computational notebook with a focus on reproducibility and a variety of open source tools, including Clerk, a programmer's assistant for Clojure.\n")]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2.align-top {:class "w-1/3"} "15:20"] [:td.border.border-slate-300.pl-2 "☕☕Break☕☕"
                                                                                   [:br]
                                                                                   [:span.font-medium.text-sm "20 min"]]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2.align-top {:class "w-1/3"} "15:40"] [:td.border.border-slate-300.pl-2 "🦉🦉Birds of a Feather🦉🦉"
                                                                                   [:br]
                                                                                   [:span.font-medium.text-sm "50 min"]
                                                                                   [:br]
                                                                                   "Have fun and learn! We will break into smaller groups to discuss topics of interest. Find out more at " [:a {:style "font-weight: bold" :href "https://gist.github.com/pesterhazy/b0d1864c1118bfca9202ca06f65eb886"} "What is a Birds of a Feather Session?"]]]

      [:tr
       [:td.border.border-slate-300.h-14.pl-2.align-top {:class "w-1/3"} "16:40"] [:td.border.border-slate-300.pl-2 "Build Your Own Little Memex with Babashka"
                                                                                   [:br]
                                                                                   [:span.text-base "Teodor Heggelund"]
                                                                                   [:br]
                                                                                   [:span.font-medium.text-sm "30 min"]
                                                                                   (abstract "A memex is a tool for information capture, information storage and information retrieval. Memexes can be used to build theory, collect research, or explore one's own taste. In this talk, we will explore the history of memexes, how a memex can aid our learning process, and how we can build our own little memex with Babashka. ")
                                                                                   (bio "Teodor builds analysis software for civil engineers from nine to five, and likes to spend after hours thinking-out-loud about programming as theory building, open source and collective knowledge management.\n")]]
      [:tr
       [:td.border.border-slate-300.h-14.pl-2.align-top {:class "w-1/3"} "17:20"] [:td.border.border-slate-300.pl-2 "Growing an Ecosystem: Lessons Learned (Closing Keynote)"
                                                                                   [:br]
                                                                                   [:span.text-base "Michiel Borkent"]
                                                                                   [:br]
                                                                                   [:span.font-medium.text-sm "40 min"]
                                                                                   (abstract "In this talk, Michiel will take us on a journey through the babashka ecosystem, how it evolved into what it currently is and the lessons he learned along the way.")
                                                                                   (bio "Michiel Borkent (\n@borkdude\n) is the author of babashka, clj-kondo, SCI, cherry and several other Clojure projects. He has been using Clojure since 2010 as a tinkerer, lecturer and professional software developer. Since 2021 he dedicates most his time to open source Clojure software. Hobbies include eating vegetables and walking.\n")]]]]

    (hr)

    [:footer.footer-1.py-8.sm:py-12
     "Credits: initial site design by Alice Kile."]]))

(convert-to-html index schedule)
