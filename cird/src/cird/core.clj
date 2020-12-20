(ns cird.core
  (:require [quil.core :as q]))

; (defn attractor [a b c d [x y]]
;   [(- (* 200 (+ (* (q/sin (* a y)) (q/sin (* a y))) (* c (q/cos (* a x)) (q/cos (* a x))))) 250)
;    (* 200 (+ (* (q/sin (* b x)) (q/sin (* b x))) (* d (q/cos (* b y)) (q/cos (* b y)))))])
; 
; (defn draw-plot-attractor [n]
;   (doseq [points (->> (iterate (partial attractor 3 2 1.5 -9.3) [0 0])
;                       (take n))]
;     (q/stroke 255 255 255 100)
;     (apply q/point points)))

(defn attractor [a b c d [x y]]
  [(* 200 (+ (* (q/sin (* a y)) (q/sin (* a y))) (* c (q/cos (* a x)) (q/cos (* a x)))))
   (* 200 (+ (* (q/sin (* b x)) (q/sin (* b x))) (* d (q/cos (* b y)) (q/cos (* b y)))))])

; (defn draw-plot-attractor [n]
;   (doseq [points (->> (iterate (partial attractor -18 3 -0.5343 -9.38723) [0 0])
;                       (take n))]
;     (q/stroke 255 255 255 100)
;     (apply q/point points)))

(defn draw-plot-attractor [n]
  (doseq [points (->> (iterate (partial attractor -8 -2 0.5343 8.38723) [0 0])
                      (take n))]
    (q/stroke 255 255 255 100)
    (apply q/point points)))

(defn draw-plot-attractor-two [n]
  (doseq [points (->> (iterate (partial attractor -18 3.6 -0.5343 -28.38723) [0 0])
                      (take n))]
    (q/stroke 255 255 255 200)
    (apply q/point points)))

(defn draw []
  (q/background 0)
  (q/with-translation [(/ (q/width) 2) (/ (q/height) 2)]
  (draw-plot-attractor 50000)
  (draw-plot-attractor-two 50000)
  (q/save "generated/attractor.png")
  ))

(declare cird)

(q/defsketch cird
  :title "strange actors"
  :size [800 800]
  :draw draw)



;([0 0] [0.5 -0.9] [0.796323228591973 -0.36908879874890776])
; [1] 0.879
; [1] 1.2921
; [1] 0.27
; [1] -0.2982028
; x           y
; 1 0.000000  0.00000000
; 2 0.500000 -0.90000000
; 3 1.243999 -0.08002343

;x[i] = sin(a*y[i-1])*sin(a*y[i-1])+c*cos(a*x[i-1])*cos(a*x[i-1]);
;y[i] = sin(b*x[i-1])*sin(b*x[i-1])+d*cos(b*y[i-1])*cos(a*x[i-1]);
;x[i] = sin(a*y[i-1])+c*cos(a*x[i-1]);
;y[i] = sin(b*x[i-1])+d*cos(b*y[i-1]);

; (defn attractor-old [a b c d [x y]]
; [(* (+ (q/sin (* a y)) c) (q/cos (* a x)))
; (* (+ (q/sin (* b x)) d) (q/cos (* b x)))])

; (defn attractor-n [[x y]]
; [(+ x 1) (- y 1)])

;(defn f [t]
;[(* t (q/sin t))
;(* t (q/cos t))])

; (defn draw-plot [end]
; (doseq [two-points (->> (range end)
; (map f)
; (partition 2 1))]
; (q/stroke 255 255 255)
; (apply q/line two-points)))

