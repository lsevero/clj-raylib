(ns examples.mouse-wheel
  (:require [clj-raylib.core :refer :all])
  (:gen-class))

(defn -main
  [& _]
  (let [width 800
        height 450
        scroll-speed 4]
    (init-window! width height "input mouse wheel")
    (set-target-fps! 60)
    (loop [state {:box {:x (- (/ width 2) 40) :y (- (/ height 2) 40)}}]
      (when-not (window-should-close?)
        (with-drawing
          (clear-background! RAYWHITE)
          (draw-text! "Use mouse wheel to move the cube up and down!" 10 10 20 DARKGRAY) 
          (draw-text! (format "Box position Y: %03d" (-> state :box :y)) 10 40 20 DARKGRAY) 
          (draw-rectangle! (:box state) [50 50] RED))
        (recur (update-in state [:box :y] #(- % (* (get-mouse-wheel-move) scroll-speed))))))))
