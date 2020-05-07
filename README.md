# clj-raylib

Clojure bidings to the awesome [raylib](https://www.raylib.com/) library

## Usage

```clojure
(ns basic
  (:require [clj-raylib.core :refer :all])
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
```

To run the examples, clone this folder and run with:
```bash
lein run -m input-mouse/-main
```
And change the namespace to the accoding example you want.

## License

Copyright © 2020 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
