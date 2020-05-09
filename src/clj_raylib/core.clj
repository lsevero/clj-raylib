(ns clj-raylib.core
  (:import [raylib.jna AudioStream BoneInfo BoundingBox Camera2D Camera3D
            CharInfo Color Font Image Material MaterialMap Matrix Mesh Model
            ModelAnimation Music NPatchInfo RAudioBuffer Ray RayHitInfo
            Raylib Rectangle RenderTexture2D Shader Sound Texture2D Transform
            Vector2 Vector3 Vector4 VrDeviceInfo Wave
            AudioStream$ByValue BoneInfo$ByValue BoundingBox$ByValue Camera2D$ByValue Camera3D$ByValue
            CharInfo$ByValue Color$ByValue Font$ByValue Image$ByValue Material$ByValue MaterialMap$ByValue Matrix$ByValue Mesh$ByValue Model$ByValue
            ModelAnimation$ByValue Music$ByValue NPatchInfo$ByValue RAudioBuffer$ByValue Ray$ByValue RayHitInfo$ByValue
            Rectangle$ByValue RenderTexture2D$ByValue Shader$ByValue Sound$ByValue Texture2D$ByValue Transform$ByValue
            Vector2$ByValue Vector3$ByValue Vector4$ByValue VrDeviceInfo$ByValue Wave$ByValue]
           [clojure.lang APersistentMap]
           )
  (:require [clojure.test :refer [is]])
  )

; System config flags
; NOTE: Used for bit masks
;begin ConfigFlag
(def ^:const FLAG-RESERVED (int 1))    ; Reserved
(def ^:const FLAG-FULLSCREEN-MODE (int 2))    ; Set to run program in fullscreen
(def ^:const FLAG-WINDOW-RESIZABLE (int 4))    ; Set to allow resizable window
(def ^:const FLAG-WINDOW-UNDECORATED (int 8))    ; Set to disable window decoration (frame and buttons)
(def ^:const FLAG-WINDOW-TRANSPARENT (int 16))   ; Set to allow transparent window
(def ^:const FLAG-WINDOW-HIDDEN (int 128))  ; Set to create the window initially hidden
(def ^:const FLAG-WINDOW-ALWAYS-RUN (int 256))  ; Set to allow windows running while minimized
(def ^:const FLAG-MSAA-4X-HINT (int 32))   ; Set to try enabling MSAA 4X
(def ^:const FLAG-VSYNC-HINT (int 64))    ; Set to try enabling V-Sync on GPU
;end ConfigFlag

; Trace log type
;begin TraceLogType
(def ^:const LOG-ALL (int 0))        ; Display all logs
(def ^:const LOG-TRACE (int 1))
(def ^:const LOG-DEBUG (int 2))
(def ^:const LOG-INFO (int 3))
(def ^:const LOG-WARNING (int 4))
(def ^:const LOG-ERROR (int 5))
(def ^:const LOG-FATAL (int 6))
(def ^:const LOG-NONE (int 7))            ; Disable logging
;end TraceLogType

; Keyboard keys
;begin KeyboardKey
    ; Alphanumeric keys
(def ^:const KEY-APOSTROPHE (int 39))
(def ^:const KEY-COMMA (int 44))
(def ^:const KEY-MINUS (int 45))
(def ^:const KEY-PERIOD (int 46))
(def ^:const KEY-SLASH (int 47))
(def ^:const KEY-ZERO (int 48))
(def ^:const KEY-ONE (int 49))
(def ^:const KEY-TWO (int 50))
(def ^:const KEY-THREE (int 51))
(def ^:const KEY-FOUR (int 52))
(def ^:const KEY-FIVE (int 53))
(def ^:const KEY-SIX (int 54))
(def ^:const KEY-SEVEN (int 55))
(def ^:const KEY-EIGHT (int 56))
(def ^:const KEY-NINE (int 57))
(def ^:const KEY-SEMICOLON (int 59))
(def ^:const KEY-EQUAL (int 61))
(def ^:const KEY-A (int 65))
(def ^:const KEY-B (int 66))
(def ^:const KEY-C (int 67))
(def ^:const KEY-D (int 68))
(def ^:const KEY-E (int 69))
(def ^:const KEY-F (int 70))
(def ^:const KEY-G (int 71))
(def ^:const KEY-H (int 72))
(def ^:const KEY-I (int 73))
(def ^:const KEY-J (int 74))
(def ^:const KEY-K (int 75))
(def ^:const KEY-L (int 76))
(def ^:const KEY-M (int 77))
(def ^:const KEY-N (int 78))
(def ^:const KEY-O (int 79))
(def ^:const KEY-P (int 80))
(def ^:const KEY-Q (int 81))
(def ^:const KEY-R (int 82))
(def ^:const KEY-S (int 83))
(def ^:const KEY-T (int 84))
(def ^:const KEY-U (int 85))
(def ^:const KEY-V (int 86))
(def ^:const KEY-W (int 87))
(def ^:const KEY-X (int 88))
(def ^:const KEY-Y (int 89))
(def ^:const KEY-Z (int 90))

    ; Function keys
(def ^:const KEY-SPACE (int 32))
(def ^:const KEY-ESCAPE (int 256))
(def ^:const KEY-ENTER (int 257))
(def ^:const KEY-TAB (int 258))
(def ^:const KEY-BACKSPACE (int 259))
(def ^:const KEY-INSERT (int 260))
(def ^:const KEY-DELETE (int 261))
(def ^:const KEY-RIGHT (int 262))
(def ^:const KEY-LEFT (int 263))
(def ^:const KEY-DOWN (int 264))
(def ^:const KEY-UP (int 265))
(def ^:const KEY-PAGE-UP (int 266))
(def ^:const KEY-PAGE-DOWN (int 267))
(def ^:const KEY-HOME (int 268))
(def ^:const KEY-END (int 269))
(def ^:const KEY-CAPS-LOCK (int 280))
(def ^:const KEY-SCROLL-LOCK (int 281))
(def ^:const KEY-NUM-LOCK (int 282))
(def ^:const KEY-PRINT-SCREEN (int 283))
(def ^:const KEY-PAUSE (int 284))
(def ^:const KEY-F1 (int 290))
(def ^:const KEY-F2 (int 291))
(def ^:const KEY-F3 (int 292))
(def ^:const KEY-F4 (int 293))
(def ^:const KEY-F5 (int 294))
(def ^:const KEY-F6 (int 295))
(def ^:const KEY-F7 (int 296))
(def ^:const KEY-F8 (int 297))
(def ^:const KEY-F9 (int 298))
(def ^:const KEY-F10 (int 299))
(def ^:const KEY-F11 (int 300))
(def ^:const KEY-F12 (int 301))
(def ^:const KEY-LEFT-SHIFT (int 340))
(def ^:const KEY-LEFT-CONTROL (int 341))
(def ^:const KEY-LEFT-ALT (int 342))
(def ^:const KEY-LEFT-SUPER (int 343))
(def ^:const KEY-RIGHT-SHIFT (int 344))
(def ^:const KEY-RIGHT-CONTROL (int 345))
(def ^:const KEY-RIGHT-ALT (int 346))
(def ^:const KEY-RIGHT-SUPER (int 347))
(def ^:const KEY-KB-MENU (int 348))
(def ^:const KEY-LEFT-BRACKET (int 91))
(def ^:const KEY-BACKSLASH (int 92))
(def ^:const KEY-RIGHT-BRACKET (int 93))
(def ^:const KEY-GRAVE (int 96))

    ; Keypad keys
(def ^:const KEY-KP-0 (int 320))
(def ^:const KEY-KP-1 (int 321))
(def ^:const KEY-KP-2 (int 322))
(def ^:const KEY-KP-3 (int 323))
(def ^:const KEY-KP-4 (int 324))
(def ^:const KEY-KP-5 (int 325))
(def ^:const KEY-KP-6 (int 326))
(def ^:const KEY-KP-7 (int 327))
(def ^:const KEY-KP-8 (int 328))
(def ^:const KEY-KP-9 (int 329))
(def ^:const KEY-KP-DECIMAL (int 330))
(def ^:const KEY-KP-DIVIDE (int 331))
(def ^:const KEY-KP-MULTIPLY (int 332))
(def ^:const KEY-KP-SUBTRACT (int 333))
(def ^:const KEY-KP-ADD (int 334))
(def ^:const KEY-KP-ENTER (int 335))
(def ^:const KEY-KP-EQUAL (int 336))
;end KeyboardKey

; Android buttons
;begin AndroidButton
(def ^:const KEY-BACK (int 4))
(def ^:const KEY-MENU (int 82))
(def ^:const KEY-VOLUME-UP (int 24))
(def ^:const KEY-VOLUME-DOWN (int 25))
;end AndroidButton

; Mouse buttons
;begin MouseButton
(def ^:const MOUSE-LEFT-BUTTON (int 0))
(def ^:const MOUSE-RIGHT-BUTTON (int 1))
(def ^:const MOUSE-MIDDLE-BUTTON (int 2))
;end MouseButton

; Gamepad number
;begin GamepadNumber
(def ^:const GAMEPAD-PLAYER1 (int 0))
(def ^:const GAMEPAD-PLAYER2 (int 1))
(def ^:const GAMEPAD-PLAYER3 (int 2))
(def ^:const GAMEPAD-PLAYER4 (int 3))
;end GamepadNumber

; Gamepad Buttons
;begin GamepadButton
    ; This is here just for error checking
(def ^:const GAMEPAD-BUTTON-UNKNOWN (int 0))

    ; This is normally a DPAD
(def ^:const GAMEPAD-BUTTON-LEFT-FACE-UP (int 1))
(def ^:const GAMEPAD-BUTTON-LEFT-FACE-RIGHT (int 2))
(def ^:const GAMEPAD-BUTTON-LEFT-FACE-DOWN (int 3))
(def ^:const GAMEPAD-BUTTON-LEFT-FACE-LEFT (int 4))

    ; This normally corresponds with PlayStation and Xbox controllers
    ; XBOX: [YXAB]
    ; PS3: [TriangleSquareCrossCircle]
    ; No support for 6 button controllers though..
(def ^:const GAMEPAD-BUTTON-RIGHT-FACE-UP (int 5))
(def ^:const GAMEPAD-BUTTON-RIGHT-FACE-RIGHT (int 6))
(def ^:const GAMEPAD-BUTTON-RIGHT-FACE-DOWN (int 7))
(def ^:const GAMEPAD-BUTTON-RIGHT-FACE-LEFT (int 8))

    ; Triggers
(def ^:const GAMEPAD-BUTTON-LEFT-TRIGGER-1 (int 9))
(def ^:const GAMEPAD-BUTTON-LEFT-TRIGGER-2 (int 10))
(def ^:const GAMEPAD-BUTTON-RIGHT-TRIGGER-1 (int 11))
(def ^:const GAMEPAD-BUTTON-RIGHT-TRIGGER-2 (int 12))

    ; These are buttons in the center of the gamepad
(def ^:const GAMEPAD-BUTTON-MIDDLE-LEFT (int 13))     ;PS3 Select
(def ^:const GAMEPAD-BUTTON-MIDDLE (int 14))          ;PS Button/XBOX Button
(def ^:const GAMEPAD-BUTTON-MIDDLE-RIGHT (int 15))    ;PS3 Start

    ; These are the joystick press in buttons
(def ^:const GAMEPAD-BUTTON-LEFT-THUMB (int 16))
(def ^:const GAMEPAD-BUTTON-RIGHT-THUMB (int 17))
;end GamepadButton

;begin GamepadAxis
    ; This is here just for error checking
(def ^:const GAMEPAD-AXIS-UNKNOWN (int 0))

    ; Left stick
(def ^:const GAMEPAD-AXIS-LEFT-X (int 1))
(def ^:const GAMEPAD-AXIS-LEFT-Y (int 2))

    ; Right stick
(def ^:const GAMEPAD-AXIS-RIGHT-X (int 3))
(def ^:const GAMEPAD-AXIS-RIGHT-Y (int 4))

    ; Pressure levels for the back triggers
(def ^:const GAMEPAD-AXIS-LEFT-TRIGGER (int 5))      ; [1..-1] (pressure-level)
(def ^:const GAMEPAD-AXIS-RIGHT-TRIGGER (int 6))      ; [1..-1] (pressure-level)
;end GamepadAxis

; Shader location point type
;begin ShaderLocationIndex
(def ^:const LOC-VERTEX-POSITION (int 0))
(def ^:const LOC-VERTEX-TEXCOORD01 (int 1))
(def ^:const LOC-VERTEX-TEXCOORD02 (int 2))
(def ^:const LOC-VERTEX-NORMAL (int 3))
(def ^:const LOC-VERTEX-TANGENT (int 4))
(def ^:const LOC-VERTEX-COLOR (int 5))
(def ^:const LOC-MATRIX-MVP (int 6))
(def ^:const LOC-MATRIX-MODEL (int 7))
(def ^:const LOC-MATRIX-VIEW (int 8))
(def ^:const LOC-MATRIX-PROJECTION (int 9))
(def ^:const LOC-VECTOR-VIEW (int 10))
(def ^:const LOC-COLOR-DIFFUSE (int 11))
(def ^:const LOC-COLOR-SPECULAR (int 12))
(def ^:const LOC-COLOR-AMBIENT (int 13))
(def ^:const LOC-MAP-ALBEDO (int 14))          ; LOC-MAP-DIFFUSE
(def ^:const LOC-MAP-METALNESS (int 15))       ; LOC-MAP-SPECULAR
(def ^:const LOC-MAP-NORMAL (int 16))
(def ^:const LOC-MAP-ROUGHNESS (int 17))
(def ^:const LOC-MAP-OCCLUSION (int 18))
(def ^:const LOC-MAP-EMISSION (int 19))
(def ^:const LOC-MAP-HEIGHT (int 20))
(def ^:const LOC-MAP-CUBEMAP (int 21))
(def ^:const LOC-MAP-IRRADIANCE (int 22))
(def ^:const LOC-MAP-PREFILTER (int 23))
(def ^:const LOC-MAP-BRDF (int 24))
;end ShaderLocationIndex

(def ^:const LOC-MAP-DIFFUSE LOC-MAP-ALBEDO)
(def ^:const LOC-MAP-SPECULAR LOC-MAP-METALNESS)

; Shader uniform data types
;begin ShaderUniformDataType
(def ^:const UNIFORM-FLOAT (int 0))
(def ^:const UNIFORM-VEC2 (int 1))
(def ^:const UNIFORM-VEC3 (int 2))
(def ^:const UNIFORM-VEC4 (int 3))
(def ^:const UNIFORM-INT (int 4))
(def ^:const UNIFORM-IVEC2 (int 5))
(def ^:const UNIFORM-IVEC3 (int 6))
(def ^:const UNIFORM-IVEC4 (int 7))
(def ^:const UNIFORM-SAMPLER2D (int 8))
;end ShaderUniformDataType

; Material map type
;begin MaterialMapType
(def ^:const MAP-ALBEDO (int 0))       ; MAP-DIFFUSE
(def ^:const MAP-METALNESS (int 1))       ; MAP-SPECULAR
(def ^:const MAP-NORMAL (int 2))
(def ^:const MAP-ROUGHNESS (int 3))
(def ^:const MAP-OCCLUSION (int 4))
(def ^:const MAP-EMISSION (int 5))
(def ^:const MAP-HEIGHT (int 6))
(def ^:const MAP-CUBEMAP (int 7))             ; NOTE: Uses GL-TEXTURE-CUBE-MAP
(def ^:const MAP-IRRADIANCE (int 8))          ; NOTE: Uses GL-TEXTURE-CUBE-MAP
(def ^:const MAP-PREFILTER (int 9))           ; NOTE: Uses GL-TEXTURE-CUBE-MAP
(def ^:const MAP-BRDF (int 10))
;end MaterialMapType

(def ^:const MAP-DIFFUSE MAP-ALBEDO)
(def ^:const MAP-SPECULAR MAP-METALNESS)

; Pixel formats
; NOTE: Support depends on OpenGL version and platform
;begin PixelFormat
(def ^:const UNCOMPRESSED-GRAYSCALE (int 1))     ; 8 bit per pixel (no alpha)
(def ^:const UNCOMPRESSED-GRAY-ALPHA (int 2))        ; 8*2 bpp (2 channels)
(def ^:const UNCOMPRESSED-R5G6B5 (int 3))            ; 16 bpp
(def ^:const UNCOMPRESSED-R8G8B8 (int 4))            ; 24 bpp
(def ^:const UNCOMPRESSED-R5G5B5A1 (int 5))          ; 16 bpp (1 bit alpha)
(def ^:const UNCOMPRESSED-R4G4B4A4 (int 6))          ; 16 bpp (4 bit alpha)
(def ^:const UNCOMPRESSED-R8G8B8A8 (int 7))          ; 32 bpp
(def ^:const UNCOMPRESSED-R32 (int 8))               ; 32 bpp (1 channel - float)
(def ^:const UNCOMPRESSED-R32G32B32 (int 9))         ; 32*3 bpp (3 channels - float)
(def ^:const UNCOMPRESSED-R32G32B32A32 (int 10))      ; 32*4 bpp (4 channels - float)
(def ^:const COMPRESSED-DXT1-RGB (int 11))            ; 4 bpp (no alpha)
(def ^:const COMPRESSED-DXT1-RGBA (int 12))           ; 4 bpp (1 bit alpha)
(def ^:const COMPRESSED-DXT3-RGBA (int 13))           ; 8 bpp
(def ^:const COMPRESSED-DXT5-RGBA (int 14))           ; 8 bpp
(def ^:const COMPRESSED-ETC1-RGB (int 15))            ; 4 bpp
(def ^:const COMPRESSED-ETC2-RGB (int 16))            ; 4 bpp
(def ^:const COMPRESSED-ETC2-EAC-RGBA (int 17))       ; 8 bpp
(def ^:const COMPRESSED-PVRT-RGB (int 18))            ; 4 bpp
(def ^:const COMPRESSED-PVRT-RGBA (int 19))           ; 4 bpp
(def ^:const COMPRESSED-ASTC-4x4-RGBA (int 20))       ; 8 bpp
(def ^:const COMPRESSED-ASTC-8x8-RGBA (int 21))        ; 2 bpp
;end PixelFormat

; Texture parameters: filter mode
; NOTE 1: Filtering considers mipmaps if available in the texture
; NOTE 2: Filter is accordingly set for minification and magnification
;begin TextureFilterMode
(def ^:const FILTER-POINT (int 0))               ; No filter just pixel aproximation
(def ^:const FILTER-BILINEAR (int 1))                ; Linear filtering
(def ^:const FILTER-TRILINEAR (int 2))               ; Trilinear filtering (linear with mipmaps)
(def ^:const FILTER-ANISOTROPIC-4X (int 3))          ; Anisotropic filtering 4x
(def ^:const FILTER-ANISOTROPIC-8X (int 4))          ; Anisotropic filtering 8x
(def ^:const FILTER-ANISOTROPIC-16X (int 5))         ; Anisotropic filtering 16x
;end TextureFilterMode

; Cubemap layout type
;begin CubemapLayoutType
(def ^:const CUBEMAP-AUTO-DETECT (int 0))        ; Automatically detect layout type
(def ^:const CUBEMAP-LINE-VERTICAL (int 1))          ; Layout is defined by a vertical line with faces
(def ^:const CUBEMAP-LINE-HORIZONTAL (int 2))        ; Layout is defined by an horizontal line with faces
(def ^:const CUBEMAP-CROSS-THREE-BY-FOUR (int 3))    ; Layout is defined by a 3x4 cross with cubemap faces
(def ^:const CUBEMAP-CROSS-FOUR-BY-THREE (int 4))    ; Layout is defined by a 4x3 cross with cubemap faces
(def ^:const CUBEMAP-PANORAMA (int 5))                ; Layout is defined by a panorama image (equirectangular map)
;end CubemapLayoutType

; Texture parameters: wrap mode
;begin TextureWrapMode
(def ^:const WRAP-REPEAT (int 0))        ; Repeats texture in tiled mode
(def ^:const WRAP-CLAMP (int 1))             ; Clamps texture to edge pixel in tiled mode
(def ^:const WRAP-MIRROR-REPEAT (int 2))     ; Mirrors and repeats the texture in tiled mode
(def ^:const WRAP-MIRROR-CLAMP (int 3))       ; Mirrors and clamps to border the texture in tiled mode
;end TextureWrapMode

; Font type defines generation method
;begin FontType
(def ^:const FONT-DEFAULT (int 0))       ; Default font generation anti-aliased
(def ^:const FONT-BITMAP (int 1))            ; Bitmap font generation no anti-aliasing
(def ^:const FONT-SDF (int 2))                ; SDF font generation requires external shader
;end FontType

; Color blending modes (pre-defined)
;begin BlendMode
(def ^:const BLEND-ALPHA (int 0))        ; Blend textures considering alpha (default)
(def ^:const BLEND-ADDITIVE (int 1))         ; Blend textures adding colors
(def ^:const BLEND-MULTIPLIED (int 2))        ; Blend textures multiplying colors
;end BlendMode

; Gestures type
; NOTE: It could be used as flags to enable only some gestures
;begin GestureType
(def ^:const GESTURE-NONE (int 0))
(def ^:const GESTURE-TAP (int 1))
(def ^:const GESTURE-DOUBLETAP (int 2))
(def ^:const GESTURE-HOLD (int 4))
(def ^:const GESTURE-DRAG (int 8))
(def ^:const GESTURE-SWIPE-RIGHT (int 16))
(def ^:const GESTURE-SWIPE-LEFT (int 32))
(def ^:const GESTURE-SWIPE-UP (int 64))
(def ^:const GESTURE-SWIPE-DOWN (int 128))
(def ^:const GESTURE-PINCH-IN (int 256))
(def ^:const GESTURE-PINCH-OUT (int 512))
;end GestureType

; Camera system modes
;begin CameraMode
(def ^:const CAMERA-CUSTOM (int 0))
(def ^:const CAMERA-FREE (int 1))
(def ^:const CAMERA-ORBITAL (int 2))
(def ^:const CAMERA-FIRST-PERSON (int 3))
(def ^:const CAMERA-THIRD-PERSON (int 4))
;end CameraMode

; Camera projection modes
;begin CameraType
(def ^:const CAMERA-PERSPECTIVE (int 0))
(def ^:const CAMERA-ORTHOGRAPHIC (int 1))
;end CameraType

; Type of n-patch
;begin NPatchType
(def ^:const NPT-9PATCH (int 0))         ; Npatch defined by 3x3 tiles
(def ^:const NPT-3PATCH-VERTICAL (int 1))    ; Npatch defined by 1x3 tiles
(def ^:const NPT-3PATCH-HORIZONTAL (int 2))   ; Npatch defined by 3x1 tiles
;end NPatchType

;begin basic colors
(def LIGHTGRAY (Color$ByValue. (int 200) (int 200) (int 200) (int 255)))
(def GRAY (Color$ByValue. (int 130) (int 130) (int 130) (int 255)))
(def DARKGRAY (Color$ByValue. (int 80) (int 80) (int 80) (int 255)))
(def YELLOW (Color$ByValue. (int 253) (int 249) (int 0) (int 255)))
(def GOLD (Color$ByValue. (int 255) (int 203) (int 0) (int 255)))
(def ORANGE (Color$ByValue. (int 255) (int 161) (int 0) (int 255)))
(def PINK (Color$ByValue. (int 255) (int 109) (int 194) (int 255)))
(def RED (Color$ByValue. (int 230) (int 41) (int 55) (int 255)))
(def MAROON (Color$ByValue. (int 190) (int 33) (int 55) (int 255)))
(def GREEN (Color$ByValue. (int 0) (int 228) (int 48) (int 255)))
(def LIME (Color$ByValue. (int 0) (int 158) (int 47) (int 255)))
(def DARKGREEN (Color$ByValue. (int 0) (int 117) (int 44) (int 255)))
(def SKYBLUE (Color$ByValue. (int 102) (int 191) (int 255) (int 255)))
(def BLUE (Color$ByValue. (int 0) (int 121) (int 241) (int 255)))
(def DARKBLUE (Color$ByValue. (int 0) (int 82) (int 172) (int 255)))
(def PURPLE (Color$ByValue. (int 200) (int 122) (int 255) (int 255)))
(def VIOLET (Color$ByValue. (int 135) (int 60) (int 190) (int 255)))
(def DARKPURPLE (Color$ByValue. (int 112) (int 31) (int 126) (int 255)))
(def BEIGE (Color$ByValue. (int 211) (int 176) (int 131) (int 255)))
(def BROWN (Color$ByValue. (int 127) (int 106) (int 79) (int 255)))
(def DARKBROWN (Color$ByValue. (int 76) (int 63) (int 47) (int 255)))
(def WHITE (Color$ByValue. (int 255) (int 255) (int 255) (int 255)))
(def BLACK (Color$ByValue. (int 0) (int 0) (int 0) (int 255)))
(def BLANK (Color$ByValue. (int 0) (int 0) (int 0) (int 0)))
(def MAGENTA (Color$ByValue. (int 255) (int 0) (int 255) (int 255)))
(def RAYWHITE (Color$ByValue. (int 245) (int 245) (int 245) (int 255)))
;end basic colors

(defmacro with-drawing
  [& body]
  `(do
     (Raylib/BeginDrawing)
     ~@body
     (Raylib/EndDrawing)))

(defmacro with-mode2d
  [camera2d & body]
  `(do
     (Raylib/BeginMode2D (Camera2D$ByValue. ~camera2d))
     ~@body
     (Raylib/EndMode2D)))

(defmacro with-mode3d
  [camera3d & body]
  `(do
     (Raylib/BeginMode3D (Camera3D$ByValue. ~camera3d))
     ~@body
     (Raylib/EndMode3D)))

(defn init-window!
  [width height title]
  (Raylib/InitWindow width height title))

(defn window-should-close?
  []
  (Raylib/WindowShouldClose))

(defn close-window!
  []
  (Raylib/CloseWindow))

(defn is-window-ready?
  []
  (Raylib/IsWindowReady))

(defn is-window-minimized?
  []
  (Raylib/IsWindowMinimized))

(defn is-window-resized?
  []
  (Raylib/IsWindowResized))

(defn is-window-hidden?
  []
  (Raylib/IsWindowHidden))

(defn is-window-fullscreen?
  []
  (Raylib/IsWindowFullscreen))

(defn toggle-fullscreen!
  []
  (Raylib/ToggleFullscreen))

(defn unhide-window!
  []
  (Raylib/UnhideWindow))

(defn set-window-icon!
  [img]
  (Raylib/SetWindowIcon (Image$ByValue. img)))

(defn set-window-title!
  [title]
  (Raylib/SetWindowTitle title))

(defn set-window-position!
  [x y]
  (Raylib/SetWindowPosition x y))

(defn set-window-monitor!
  [monitor]
  (Raylib/SetWindowMonitor monitor))

(defn set-window-min-size!
  [w h]
  (Raylib/SetWindowMinSize w h))

(defn set-target-fps!
  [fps]
  (Raylib/SetTargetFPS fps))

(defn clear-background!
  [color]
  (Raylib/ClearBackground (Color$ByValue. color)))

(defn draw-text!
  [^String text posx posy size color]
  (Raylib/DrawText text posx posy size color))

(defn draw-circle!
  ([v2 size color]
   (Raylib/DrawCircleV (Vector2$ByValue. v2) size color))
  ([posx posy size color]
   (Raylib/DrawCircle posx posy size color)))

(defn draw-rectangle!
  ([rec color]
   (Raylib/DrawRectangleRec (Rectangle$ByValue. rec) (Color$ByValue. color)))
  ([pos size color]
   (Raylib/DrawRectangleV (Vector2$ByValue. pos)
                          (Vector2$ByValue. size)
                          (Color$ByValue. color)))
  ([posx posy w h color]
   (Raylib/DrawRectangle posx posy w h (Color$ByValue. color))))

(defn is-key-down?
  [k]
  (Raylib/IsKeyDown k))

(defn is-mouse-button-pressed?
  [button]
  (Raylib/IsMouseButtonPressed button))

(defn is-mouse-button-down?
  [button]
  (Raylib/IsMouseButtonDown button))

(defn is-mouse-button-released?
  [button]
  (Raylib/IsMouseButtonReleased button))

(defn is-mouse-button-up?
  [button]
  (Raylib/IsMouseButtonUp button))

(defn get-mouse-position
  []
  (Raylib/GetMousePosition))

(defn get-mouse-wheel-move
  []
  (Raylib/GetMouseWheelMove))
