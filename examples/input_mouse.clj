(ns input-mouse
  (:require [clj-raylib.core :refer :all])
  (:gen-class))

(defn -main
  [& _]
  (let [width 800
        height 450]
    (init-window! width height "input mouse")
    (set-target-fps! 60)
    (loop [state {:ball-color DARKBLUE}]
      (when-not (window-should-close?)
        (with-drawing
          (clear-background! RAYWHITE)
          (draw-text! "move the ball with mouse and click mouse button to change color" 10 10 20 DARKGRAY) 
          (draw-circle! (get-mouse-position) 50 (:ball-color state)))
        (recur (assoc state :ball-color (cond
                                          (is-mouse-button-down? MOUSE-LEFT-BUTTON) VIOLET
                                          (is-mouse-button-down? MOUSE-MIDDLE-BUTTON) LIME
                                          (is-mouse-button-down? MOUSE-RIGHT-BUTTON) RED
                                          :else DARKBLUE)))))))
