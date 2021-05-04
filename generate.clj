#!/usr/bin/env bb

(require '[clojure.edn :as edn]
         '[hiccup.core :as hiccup])

(defn convert-to-html
  [site]
  (spit
    "index.html"
    (-> "data.edn"
        slurp
        edn/read-string
        site
        (hiccup/html))))

(defn hr []
  [:hr.mx-auto.my-20.lg:my-20])

(defn site
  [_]
  [:html
   [:head
    [:meta {:charset "UTF-8"}]
    [:title "Babashka"]
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
    [:link {:rel "stylesheet" :href "https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"}]
    [:link {:rel "stylesheet" :href "https://cdnjs.cloudflare.com/ajax/libs/prism/1.23.0/themes/prism-solarizedlight.min.css"}]
    [:link {:href "https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" :rel "stylesheet"}]
    [:link {:href "https://fonts.gstatic.com" :rel "preconnect"}]
    [:link {:rel "stylesheet" :href "https://fonts.googleapis.com/css2?family=Forum&family=Raleway:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"}]
    [:script {:src "https://cdnjs.cloudflare.com/ajax/libs/prism/1.23.0/prism.min.js" :defer true}]
    [:script {:src "https://cdnjs.cloudflare.com/ajax/libs/prism/1.23.0/plugins/autoloader/prism-autoloader.min.js" :defer true}]]


   [:body.overflow-x-hidden {:style "font-family: 'Raleway', sans-serif;"}
    [:div.absolute {:style "width: 180vw; height: 200vh; background: linear-gradient(90deg, #B70000,rgba(227, 30, 37, 0.5) 50%, rgba(255, 255, 255, 0.1)); transform: rotateZ(-35deg) translate(-130vw, -150vh);"}]
    [:header.w-full.shadow-md.relative.bg-white {:style "box-shadow: 0 4px 10px 0 rgba(0, 0, 0, 0.05);"}
     [:div.container.h-auto.mx-auto.grid.grid-cols-1.py-6.lg:grid-flow-col.lg:auto-cols-max
      [:h1.text-lg.mb-5.mx-auto.lg:mx-0.lg:mb-auto.col-end-auto
       [:img {:src "https://raw.githubusercontent.com/babashka/babashka/master/logo/babashka.svg"
              :width "200px"}]]

      [:nav.flex.flex-row.flex-nowrap.mb-5.lg:mb-0.mx-auto
       [:a.my-auto.mx-2.sm:mx-10.hover:underline {:href "https://github.com/babashka/babashka#installation"} "Install"]
       [:a.my-auto.mx-2.sm:mx-10.hover:underline {:href "http://book.babashka.org"} "Docs"]
       [:a.my-auto.mx-2.sm:mx-10.hover:underline {:href "https://github.com/babashka/babashka/blob/master/doc/news.md"} "News"]
       [:a.my-auto.mx-2.sm:mx-10.hover:underline {:href "https://github.com/babashka/babashka/blob/master/doc/dev.md"}
        "Contribute"]]

      [:nav.flex.flex-row.flex-nowrap.mx-auto
       [:a.my-auto.mx-5 {:href "https://github.com/babashka/babashka"}
        [:img {:src "./assets/github.svg"}]]
       [:a.my-auto.mx-5 {:href "https://app.slack.com/client/T03RZGPFR/CLX41ASCS"}
        [:img {:src "./assets/slack.svg"
               :width "33x"}]]
       [:a.my-auto.mx-5 {:href "https://twitter.com/search?q=%23babashka&src=typed_query&f=live"}
        [:img {:src "./assets/twitter.svg"}]]
       [:a.my-auto.mx-5 {:href "https://www.youtube.com/results?search_query=%23babashka+OR+%22babashka%22"}
        [:img {:src "./assets/youtube.svg"}]]]]]

    [:main.relative.px-10.pt-24.md:px-32.md:pt-32.lg:px-80.lg:pt-60
     [:section
      [:h1.text-6xl {:style "font-family: Forum, serif;"} "Fast native Clojure scripting runtime"]
      [:p.text-xl.mt-12.break-word "Avoid switching between Clojure and bash scripts. Enjoy your parens on the command line."]
      [:div.mt-20
       [:pre [:code.language-clojure "time bb -e '{:ci (System/getenv \"CI\")}'
{:ci \"true\"}
0.01s user 0.01s system 79% cpu 0.026 total"]]]]

     (hr)

     [:section
      [:h1.text-5xl {:style "font-family: Forum, serif;"} "Features"]
      [:div.mt-10.grid.gap-4.grid-cols-1.lg:grid-cols-3.lg:gap-8
       [:article
        [:h3.text-3xl {:style "font-family: Forum, serif;"} "Instant startup"]
        [:p.text-xl.mt-4 "Leveraging GraalVM native-image and the Small Clojure Interpreter, babashka is a self-contained and instantly starting scripting environment."]]
       [:article
        [:h3.text-3xl {:style "font-family: Forum, serif;"}
         [:a {:href "https://book.babashka.org/#libraries"}
          "Batteries included"]]
        [:p.text-xl.mt-4 "Babashka comes with scripting batteries included:
        tools.cli, cheshire, babashka.fs, babashka.process, java.time and many
        more libraries and classes."]]
       [:article
        [:h3.text-3xl {:style "font-family: Forum, serif;"} "Cross-platform"]
        [:p.text-xl.mt-4 "Babashka scripts work on linux, macOS and Windows."]]
       [:article
        [:h3.text-3xl {:style "font-family: Forum, serif;"}
         [:a {:href "https://github.com/babashka/babashka/blob/master/doc/projects.md#libraries"} "Libraries"]]
        [:p.text-xl.mt-4 "Besides the built-in libraries, babashka is able to
        load libraries from source, tapping into the world of already existing
        Clojure libraries."]]
       [:article
        [:h3.text-3xl {:style "font-family: Forum, serif;"}
         "Multi-threaded"]
        [:p.text-xl.mt-4 "Babashka supports real JVM threads and like Clojure,
        supports futures and dynamic thread-locally bound vars"]]

       [:article
        [:h3.text-3xl {:style "font-family: Forum, serif;"}
         [:a {:href "https://github.com/babashka/babashka/issues/778"}
          "Task runner"]]
        [:p.text-xl.mt-4 "Babashka features a built-in task runner which covers the most popular use cases of make, just and npm scripts. Stable version will be announced soon."]]

       [:article
        [:h3.text-3xl {:style "font-family: Forum, serif;"}
         [:a {:href "https://github.com/babashka/pod-registry"}
          "Pods"]]
        [:p.text-xl.mt-4 "Babashka can shell out to other CLI programs like you
        are used to in bash. It goes one step further and offers seamless
        integration with other binaries using the pod protocol. Pods can be implemented in any language, including Clojure, Rust and Go."]]
       ]]

     (hr)

     [:section
      [:div.col-start-1.col-end-7.row-start-2.row-end-3.lg:row-start-1.lg:row-end-2.lg:col-start-1.lg:col-end-4
       [:h1.text-5xl {:style "font-family: Forum, serif;"} "Community"]
       [:p.text-xl.mt-10 "The "
        [:a {:href "https://app.slack.com/client/T03RZGPFR/CLX41ASCS"}
         "babashka channel on Clojurians Slack" ]
        " has quickly summoned more than 500 members. We are sharing ideas and helping each other out with questions and issues."
        [:a {:href "https://github.com/babashka/babashka/discussions"} " Github
         discussions"] " can be used to reach out for any topic if you are more
         into slower moving communication."]
       [:div.my-4.grid.grid-cols-2.w-80.gap-4
        [:button.border.border-gray-900.p-2
         [:a {:href "https://app.slack.com/client/T03RZGPFR/CLX41ASCS"}
          "Clojurians Slack"]]
        [:button.border.border-gray-900.p-2
         [:a {:href "https://github.com/babashka/babashka/discussions"}
          "Github Discussions"]]]]]

     (hr)

     [:section;; .grid.grid-cols-6.gap-4.grid-rows-2.lg:grid-rows-1
      [:div.col-start-1.col-end-7.row-start-2.row-end-3.lg:row-start-1.lg:row-end-2.lg:col-start-1.lg:col-end-4
       [:h1.text-5xl {:style "font-family: Forum, serif;"} "Support the project"]

       [:p.text-xl.mt-10
        "If you enjoy babashka and it is helping you succeed, consider
        sponsoring the development and maintainance of this project."]
       [:div.my-4.grid.grid-cols-2.w-80.gap-4
        [:button.border.border-gray-900.p-2
         [:a {:href "https://github.com/sponsors/borkdude"}
          "Github Sponsors"]]
        [:button.border.border-gray-900.p-2
         [:a {:href "https://opencollective.com/babashka"}
          "OpenCollective"]]]]]

     [:div.mx-auto.my-20.lg:my-20]
     [:hr]
     [:footer.footer-1.py-8.sm:py-12
      "Credits: initial site design by Alice Kile."]
     ,]]])


(convert-to-html site)
