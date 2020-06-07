(ns examples.camera2d
  (:require [clj-raylib.core :refer :all])
  (:gen-class))

(defn -main
  [& _]
  (let [screen-width 800
        screen-height 450
        max-buildings 100
        building-width 100
        player-size 40
        buildings (->> (range max-buildings)
                       (map (partial * building-width))
                       (map #(let [building-height (get-random-value 100 800)]
                               {:width building-width
                                :height building-height
                                :y (- screen-height 130 building-height)
                                :x (- 6000 (* 1 %))})))
        building-colors (repeatedly max-buildings #(do {:r (get-random-value 200 240)
                                                        :g (get-random-value 200 240)
                                                        :b (get-random-value 200 250)
                                                        :a 255}))]
    (init-window! screen-width screen-height "raylib [core] example - 2d camera")
    (set-target-fps! 60)
    (loop [state {:player {:x 400
                           :y 280
                           :width player-size
                           :height player-size}
                  :camera {:target [(+ player-size 20) (+ player-size 20)]
                           :offset [(/ screen-width 2) (/ screen-height 2)]
                           :rotation 0.0
                           :zoom 1.0}}]
      (when-not (window-should-close?)
        (with-drawing
          (clear-background! RAYWHITE)
          (with-mode-2d (:camera state)
            (draw-rectangle! -6000 320 13000 8000 DARKGRAY)
            (mapv #(draw-rectangle! %1 %2) buildings building-colors)            
            (draw-rectangle! (:player state) RED)
            (draw-line! (get-in state [:camera :target 0])
                        (* 10 (- screen-height))
                        (get-in state [:camera :target 0])
                        (* screen-height 10)
                        GREEN)
            (draw-line! (* (- screen-width) 10)
                        (get-in state [:camera :target 1])
                        (* screen-width 10)
                        (get-in state [:camera :target 1])
                        GREEN))
          (draw-text! "SCREEN AREA" 640 10 20 RED)          
          (draw-rectangle! 0 0 screen-width 5 RED)
          (draw-rectangle! 0 5 5 (- screen-height 10) RED)
          (draw-rectangle! (- screen-width 5) 5 5 (- screen-height 10) RED)
          (draw-rectangle! 0 (- screen-height 5) screen-width 5 RED)
          (draw-rectangle! 10 10 250 113 (fade SKYBLUE 0.5))
          (draw-rectangle-lines! 10 10 250 113 BLUE)
          (draw-text! "Free 2d camera controls:" 20 20 10 BLACK)
          (draw-text! "- Right/Left to move Offset" 40 40 10 DARKGRAY)
          (draw-text! "- Mouse Wheel to Zoom in-out" 40 60 10 DARKGRAY)
          (draw-text! "- A / S to Rotate" 40 80 10 DARKGRAY)
          (draw-text! "- R to reset Zoom and Rotation", 40, 100, 10, DARKGRAY))
        (recur (-> state
                   (#(if (is-key-down? KEY-RIGHT) (update-in % [:player :x] + 2) %))
                   (#(if (is-key-down? KEY-LEFT) (update-in % [:player :x] - 2) %))
                   (#(if (is-key-down? KEY-A) (update-in % [:camera :rotation] dec) %))
                   (#(if (is-key-down? KEY-S) (update-in % [:camera :rotation] inc) %))
                   (#(if (> (get-in % [:camera :rotation]) 40.0)
                       (assoc-in % [:camera :rotation] 40.0)
                       %))
                   (#(if (< (get-in % [:camera :rotation]) -40.0)
                       (assoc-in % [:camera :rotation] -40.0)
                       %))
                   (update-in [:camera :zoom] + (* (get-mouse-wheel-move) 0.05))
                   (#(assoc-in % [:camera :target] [(+ (get-in % [:player :x]) 20) (+ (get-in % [:player :y]) 20)]))
                   (#(if (> (get-in % [:camera :zoom]) 3.0)
                       (assoc-in % [:camera :zoom] 3.0)
                       %))
                   (#(if (< (get-in % [:camera :zoom]) 0.1)
                       (assoc-in % [:camera :zoom] 0.1)
                       %))
                   (#(if (is-key-pressed? KEY-R)
                       (-> % 
                         (assoc-in [:camera :zoom] 1.0)
                         (assoc-in [:camera :rotation] 0.0))
                       %))))))
    (close-window!)))

