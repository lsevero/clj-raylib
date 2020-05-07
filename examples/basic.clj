(ns basic
  (:require [clj-raylib.core :refer :all])
  (:import [raylib.jna Vector2$ByReference Vector2$ByValue Raylib])
  (:gen-class))

(defn -main
  [& _]
  (let [width 800
        height 450]
    (init-window! width height "input keys")
    (set-target-fps! 60)
    (loop [state {:ball [(/ width 2) (/ height 2)]}]
      (when-not (window-should-close?)
        (with-drawing
          (clear-background! RAYWHITE)
          (draw-text! "move the ball with arrow keys" 10 10 20 DARKGRAY) 
          (draw-circle! (:ball state) 50 MAROON))
        (recur (-> state
                   (#(if (is-key-down? KEY-RIGHT) (update-in % [:ball 0] inc) %))
                   (#(if (is-key-down? KEY-LEFT) (update-in % [:ball 0] dec) %))
                   (#(if (is-key-down? KEY-UP) (update-in % [:ball 1] dec) %))
                   (#(if (is-key-down? KEY-DOWN) (update-in % [:ball 1] inc) %))))))))
