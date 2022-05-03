(ns nbb.impl.uix
  {:no-doc true}
  (:require [uix.dom.alpha :as uix.dom]
            [uix.core.alpha :as uix]
            [nbb.core :as nbb]
            [sci.core :as sci :refer [copy-var]]))

(def core-ns (sci/create-ns 'uix.core.alpha nil))
(def dom-ns  (sci/create-ns 'uix.dom.alpha nil))

(def core-namespace
  {'state            (copy-var uix/state core-ns)
   'callback         (copy-var uix/callback core-ns)
   'ref              (copy-var uix/ref core-ns)
   'effect!          (copy-var uix/effect! core-ns)
   'layout-effect!   (copy-var uix/layout-effect! core-ns)
   'memo             (copy-var uix/memo core-ns)
   'memoize          (copy-var uix/memoize core-ns)
   'context          (copy-var uix/context core-ns)
   'create-context   (copy-var uix/create-context core-ns)
   'as-react         (copy-var uix/as-react core-ns)
   'as-element       (copy-var uix/as-element core-ns)
   'add-transform-fn (copy-var uix/add-transform-fn core-ns)})

(def dom-namespace
  {'render                  (copy-var uix.dom/render dom-ns)
   'render-to-string        (copy-var uix.dom/render-to-string dom-ns)
   'render-to-static-markup (copy-var uix.dom/render-to-static-markup dom-ns)})

(defn init []
  (nbb/register-plugin!
   ::uix
   {:namespaces {'uix.core.alpha core-namespace
                 'uix.dom.alpha  dom-namespace}}))
