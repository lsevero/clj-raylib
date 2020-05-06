(ns basic
  (:require [clj-raylib.core :refer :all])
  (:import [raylib.jna Vector2$ByReference Vector2$ByValue Raylib])
  (:gen-class))

;(defmethod print-method Vector2 [^Vector2 o ^java.io.Writer w]
  ;(.write w (str "#vector2[" (.-x o) (.-y o) "]")))
;(defmethod print-dup Vector2 [^Vector2 o ^java.io.Writer w]
  ;(print-method o w))

(defn -main
  [& _]
  (let [width (long 800)
        height (long 450)]
    (Raylib/InitWindow width height "testeeee")
    (Raylib/SetTargetFPS (long 60))
    (loop [state {:ball [(/ width 2) (/ height 2)]}]
      (if (Raylib/WindowShouldClose)
        nil
        (do
          (Raylib/BeginDrawing)

          (Raylib/ClearBackground RAYWHITE)
          (Raylib/DrawText "move the ball with arrow keys" (long 10) (long 10) (long 20) DARKGRAY) 
          (Raylib/DrawCircle (long 400) (long 300) (double 50) PURPLE) 
          (Raylib/DrawCircleV (-> state ^clojure.lang.APersistentVector (:ball) Vector2$ByValue.) (double 50) BLUE) 
          (Raylib/DrawRectangle (long 0) (long 0) (long 80) (long 80) RED)

          (Raylib/EndDrawing)
          (recur state))
        )
      )
    )
  )

(comment (-main))
(comment (str (Vector2. 0 0)))
