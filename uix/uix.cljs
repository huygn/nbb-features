(ns uix
  (:require [uix.core.alpha :as uix]
            [uix.dom.alpha :as uix.dom]
            ["react-dom/server" :as dom-server]))

(set! (.-ReactDOMServer js/global) dom-server)

(defn button [{:keys [on-click]} text]
  [:button.btn {:on-click on-click}
   text])

(defn app []
  (let [state* (uix/state 0)]
    [:<>
     [button {:on-click #(swap! state* dec)} "-"]
     [:span @state*]
     [button {:on-click #(swap! state* inc)} "+"]]))

(println
 (uix.dom/render-to-string [app]))
