(ns cird.core
  (:require [quil.core :as q]))

(defn attractor [a b c d [x y]]
  [(* 200 (+ (* (q/sin (* a y)) (q/sin (* a y))) (* c (q/cos (* a x)) (q/cos (* a x)))))
   (* 200 (+ (* (q/sin (* b x)) (q/sin (* b x))) (* d (q/cos (* b y)) (q/cos (* b y)))))])

(defn offset 
  ([offset-x [x y]] (offset offset-x 0 [x y]))
  ([offset-x offset-y [x y]]
    [(+ x offset-x)
     (+ y offset-y)]))

(defn draw-plot [n alpha f]
  (doseq [points (take n (iterate f [0 0]))]
    (q/stroke 255 255 255 alpha)
    (apply q/point points)))

(defn draw []
  (q/background 0)
  (q/with-translation [(/ (q/width) 2) (/ (q/height) 2)]
  (draw-plot 50000 80 #(attractor -8 -2 0.5343 8.38723 %))
  (draw-plot 50000 80 #(offset -230 100 (attractor 1 -2 3.5343 3.38723 %)))
  (draw-plot 50000 80 #(offset -400 (attractor -18 3.6 -0.5343 -28.38723 %)))))

(declare cird)

(q/defsketch cird
  :title "scratch"
  :size [800 800]
  :draw draw)
