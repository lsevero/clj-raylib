(ns clj-raylib.core
  (:refer-clojure :exclude [name format replace])
  (:import [raylib.jna AudioStream BoneInfo BoundingBox Camera2D Camera3D
            CharInfo Color Font Image Material MaterialMap Matrix Mesh Model
            ModelAnimation Music NPatchInfo RAudioBuffer Ray RayHitInfo
            Raylib Rectangle RenderTexture2D Shader Sound Texture2D Transform
            Vector2 Vector3 Vector4 VrDeviceInfo Wave
            AudioStream$ByValue BoneInfo$ByValue BoundingBox$ByValue Camera2D$ByValue Camera3D$ByValue
            CharInfo$ByValue Color$ByValue Font$ByValue Image$ByValue Material$ByValue MaterialMap$ByValue Matrix$ByValue Mesh$ByValue Model$ByValue
            ModelAnimation$ByValue Music$ByValue NPatchInfo$ByValue RAudioBuffer$ByValue Ray$ByValue RayHitInfo$ByValue
            Rectangle$ByValue RenderTexture2D$ByValue Shader$ByValue Sound$ByValue Texture2D$ByValue Transform$ByValue
            Vector2$ByValue Vector3$ByValue Vector4$ByValue VrDeviceInfo$ByValue Wave$ByValue
            Camera3D$ByReference Vector2$ByReference Image$ByReference Texture2D$ByReference
            ]
           [com.sun.jna.ptr IntByReference]
           ))

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

(defn hide-window!
  []
  (Raylib/HideWindow))

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

(defn set-window-size!
  [w h]
  (Raylib/SetWindowSize w h))

(defn get-window-handle
  []
  (Raylib/GetWindowHandle))

(defn get-screen-width
  []
  (Raylib/GetScreenWidth))

(defn get-screen-height
  []
  (Raylib/GetScreenHeight))

(defn get-monitor-count
  []
  (Raylib/GetMonitorCount))

(defn get-monitor-width
  [monitor]
  (Raylib/GetMonitorWidth monitor))

(defn get-monitor-height
  [monitor]
  (Raylib/GetMonitorHeight monitor))

(defn get-monitor-physical-width
  [monitor]
  (Raylib/GetMonitorPhysicalWidth monitor))

(defn get-monitor-physical-height
  [monitor]
  (Raylib/GetMonitorPhysicalHeight monitor))

(defn get-window-position
  []
  (Raylib/GetWindowPosition))

(defn get-monitor-name
  [monitor]
  (Raylib/GetMonitorName monitor))

(defn get-clipboard-text
  []
  (Raylib/GetClipboardText))

(defn set-clipboard-text!
  [txt]
  (Raylib/SetClipboardText txt))

(defn show-cursor!
  []
  (Raylib/ShowCursor))

(defn hide-cursor!
  []
  (Raylib/HideCursor))

(defn is-cursor-hidden?
  []
  (Raylib/IsCursorHidden))

(defn enable-cursor!
  []
  (Raylib/EnableCursor))

(defn disable-cursor!
  []
  (Raylib/DisableCursor))

(defn clear-background!
  [color]
  (Raylib/ClearBackground (Color$ByValue. color)))

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

(defmacro with-texture-mode
  [target & body]
  `(do
     (Raylib/BeginTextureMode (RenderTexture2D$ByValue. ~target))
     ~@body
     (Raylib/EndTextureMode)))

(defmacro with-scissor-mode
  [x y w h & body]
  `(do
     (Raylib/BeginScissorMode ~x ~y ~w ~h)
     ~@body
     (Raylib/EndScissorMode)))

(defn get-mouse-ray
  [mouse-pos camera3d]
  (Raylib/GetMouseRay (Vector2$ByValue. mouse-pos) (Camera3D$ByValue. camera3d)))

(defn get-camera-matrix
  [camera3d]
  (Raylib/GetCameraMatrix (Camera3D$ByValue. camera3d)))

(defn get-camera-matrix2d
  [camera2d]
  (Raylib/GetCameraMatrix2D (Camera2D$ByValue. camera2d)))

(defn get-world-to-screen
  ([vector3 camera3d]
   (Raylib/GetWorldToScreen (Vector3$ByValue. vector3) (Camera3D$ByValue. camera3d)))
  ([vector3 camera3d w h]
   (Raylib/GetWorldToScreenEx (Vector3$ByValue. vector3) (Camera3D$ByValue. camera3d) w h)))

(defn get-world-to-screen-2d
  [vector2 camera2d]
  (Raylib/GetWorldToScreen2D (Vector2$ByValue. vector2) (Camera2D$ByValue. camera2d)))

(defn get-screen-to-world-2d
  [vector2 camera2d]
  (Raylib/GetScreenToWorld2D (Vector2$ByValue. vector2) (Camera2D$ByValue. camera2d)))

(defn set-target-fps!
  [fps]
  (Raylib/SetTargetFPS fps))

(defn get-fps
  []
  (Raylib/GetFPS))

(defn get-frame-time
  []
  (Raylib/GetFrameTime))

(defn get-time
  []
  (Raylib/GetTime))

(defn is-key-pressed?
  [k]
  (Raylib/IsKeyPressed k))

(defn is-key-down?
  [k]
  (Raylib/IsKeyDown k))

(defn is-key-released?
  [k]
  (Raylib/IsKeyReleased k))

(defn if-key-up?
  [k]
  (Raylib/IsKeyUp k))

(defn set-exit-key!
  [k]
  (Raylib/SetExitKey k))

(defn get-key-pressed
  []
  (Raylib/GetKeyPressed))

(defn is-gamepad-available?
  [gamepad]
  (Raylib/IsGamepadAvailable gamepad))

(defn is-gamepad-name?
  [gamepad name]
  (Raylib/IsGamepadName gamepad name))

(defn get-gamepad-name
  [gamepad]
  (Raylib/GetGamepadName gamepad))

(defn is-gamepad-button-pressed?
  [gamepad button]
  (Raylib/IsGamepadButtonPressed gamepad button))

(defn is-gamepad-button-down?
  [gamepad button]
  (Raylib/IsGamepadButtonDown gamepad button))

(defn is-gamepad-button-released?
  [gamepad button]
  (Raylib/IsGamepadButtonReleased gamepad button))

(defn is-gamepad-button-up?
  [gamepad button]
  (Raylib/IsGamepadButtonUp gamepad button))

(defn get-gamepad-button-pressed
  []
  (Raylib/GetGamepadButtonPressed))

(defn get-gamepad-axis-count
  [gamepad]
  (Raylib/GetGamepadAxisCount gamepad))

(defn get-gamepad-axis-movement
  [gamepad axis]
  (Raylib/GetGamepadAxisMovement gamepad axis))

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

(defn get-mouse-x
  []
  (Raylib/GetMouseX))

(defn get-mouse-y
  []
  (Raylib/GetMouseY))

(defn get-mouse-position
  []
  (Raylib/GetMousePosition))

(defn set-mouse-position!
  [x y]
  (Raylib/SetMousePosition x y))

(defn set-mouse-offset!
  [offsetx offsety]
  (Raylib/SetMouseOffset offsetx offsety))

(defn set-mouse-scale!
  [scalex scaley]
  (Raylib/SetMouseScale scalex scaley))

(defn get-mouse-wheel-move
  []
  (Raylib/GetMouseWheelMove))

(defn get-touch-x
  []
  (Raylib/GetTouchX))

(defn get-touch-y
  []
  (Raylib/GetTouchY))

(defn get-touch-position
  [index]
  (Raylib/GetTouchPosition index))

(defn set-gestures-enabled
  [gesture-flags]
  (Raylib/SetGesturesEnabled gesture-flags))

(defn is-gesture-detected?
  [gesture]
  (Raylib/IsGestureDetected gesture))

(defn get-gesture-detect
  []
  (Raylib/GetGestureDetected))

(defn get-touch-points-count
  []
  (Raylib/GetTouchPointsCount))

(defn get-gesture-hold-duration
  []
  (Raylib/GetGestureHoldDuration))

(defn get-gesture-drag-vector
  []
  (Raylib/GetGestureDragVector))

(defn get-gesture-drag-angle
  []
  (Raylib/GetGestureDragAngle))

(defn get-gesture-pinch-vector
  []
  (Raylib/GetGesturePinchVector))

(defn get-gesture-pinch-angle
  []
  (Raylib/GetGesturePinchAngle))

(defn set-camera-mode!
  [camera3d mode]
  (Raylib/SetCameraMode (Camera3D$ByValue. camera3d) mode))

(defn update-camera!
  [camera3d]
  (let [camera-by-ref (Camera3D$ByReference. camera3d)]
    (Raylib/UpdateCamera camera-by-ref)
    camera-by-ref))

(defn set-camera-pan-control!
  [k]
  (Raylib/SetCameraPanControl k))

(defn set-camera-alt-control!
  [k]
  (Raylib/SetCameraAltControl k))

(defn set-camera-smooth-zoom-control!
  [k]
  (Raylib/SetCameraSmoothZoomControl k))

(defn set-camera-move-controls!
  [front-key back-key right-key left-key up-key down-key]
  (Raylib/SetCameraMoveControls front-key back-key right-key left-key up-key down-key))

(defn draw-pixel!
  ([posx posy color]
   (Raylib/DrawPixel posx posy (Color$ByValue. color)))
  ([pos color]
   (Raylib/DrawPixelV (Vector2$ByValue. pos) (Color$ByValue. color))))

(defn draw-line!
  ([start-pos-x start-pos-y end-pos-x end-pos-y color]
   (Raylib/DrawLine start-pos-x start-pos-y end-pos-x end-pos-y (Color$ByValue. color)))
  ([start-vector end-vector color]
   (Raylib/DrawLineV (Vector2$ByValue. start-vector) (Vector2$ByValue. end-vector) (Color$ByValue. color)))
  ([start-vector end-vector thick color]
   (Raylib/DrawLineEx (Vector2$ByValue. start-vector) (Vector2$ByValue. end-vector) thick (Color$ByValue. color))))

(defn draw-line-bezier!
  [start-vector end-vector thick color]
   (Raylib/DrawLineBezier (Vector2$ByValue. start-vector) (Vector2$ByValue. end-vector) thick (Color$ByValue. color)))

;(defn draw-line-strip!
  ;[points num-points color]
  ;(Raylib/DrawLineStrip (Vector2$ByReference. points) num-points (Color$ByValue. color)))

(defn draw-circle!
  ([v2 size color]
   (Raylib/DrawCircleV (Vector2$ByValue. v2) size color))
  ([posx posy size color]
   (Raylib/DrawCircle posx posy size color)))

(defn draw-circle-sector!
  [center radius start-angle end-angle segments color]
  (Raylib/DrawCircleSector (Vector2$ByValue. center) radius start-angle end-angle segments (Color$ByValue. color)))

(defn draw-circle-sector-lines!
  [center radius start-angle end-angle segments color]
  (Raylib/DrawCircleSectorLines (Vector2$ByValue. center) radius start-angle end-angle segments (Color$ByValue. color)))

(defn draw-circle-gradient!
  [centerx centery radius color1 color2]
  (Raylib/DrawCircleGradient centerx centery radius (Color$ByValue. color1) (Color$ByValue. color2)))

(defn draw-circle-lines!
  [centerx centery radius color]
  (Raylib/DrawCircleLines centerx centery radius (Color$ByValue. color)))

(defn draw-ellipse!
  [centerx centery radiush radiusv color]
  (Raylib/DrawEllipse centerx centery radiush radiusv (Color$ByValue. color)))

(defn draw-ellipse-lines!
  [centerx centery radiush radiusv color]
  (Raylib/DrawEllipseLines centerx centery radiush radiusv (Color$ByValue. color)))

(defn draw-ring!
  [center inner-radius outer-radius start-angle end-angle segments color]
  (Raylib/DrawRing (Vector2$ByValue. center) inner-radius outer-radius start-angle end-angle segments (Color$ByValue. color)))

(defn draw-ring-lines!
  [center inner-radius outer-radius start-angle end-angle segments color]
  (Raylib/DrawRingLines (Vector2$ByValue. center) inner-radius outer-radius start-angle end-angle segments (Color$ByValue. color)))

(defn draw-rectangle!
  ([rec color]
   (Raylib/DrawRectangleRec (Rectangle$ByValue. rec) (Color$ByValue. color)))
  ([pos size color]
   (Raylib/DrawRectangleV (Vector2$ByValue. pos)
                          (Vector2$ByValue. size)
                          (Color$ByValue. color)))
  ([posx posy w h color]
   (Raylib/DrawRectangle posx posy w h (Color$ByValue. color))))

(defn draw-rectangle-pro!
  [rec origin rotation color]
  (Raylib/DrawRectanglePro (Rectangle$ByValue. rec) (Vector2$ByValue. origin) rotation (Color$ByValue. color)))

(defn draw-rectangle-gradient-v!
  [posx posy w h color1 color2]
  (Raylib/DrawRectangleGradientV posx posy w h (Color$ByValue. color1) (Color$ByValue. color2)))

(defn draw-rectangle-gradient-h!
  [posx posy w h color1 color2]
  (Raylib/DrawRectangleGradientH posx posy w h (Color$ByValue. color1) (Color$ByValue. color2)))

(defn draw-rectangle-gradient-ex!
  [rec color1 color2 color3 color4]
  (Raylib/DrawRectangleGradientEx (Rectangle$ByValue. rec) (Color$ByValue. color1) (Color$ByValue. color2)
                                  (Color$ByValue. color3) (Color$ByValue. color4)))

(defn draw-rectangle-lines!
  ([posx posy w h color]
   (Raylib/DrawRectangleLines posx posy w h (Color$ByValue. color)))
  ([rec linethick color]
   (Raylib/DrawRectangleLinesEx (Rectangle$ByValue. rec) linethick (Color$ByValue. color))))

(defn draw-rectangle-rounded!
  [rec roundness segments color]
  (Raylib/DrawRectangleRounded (Rectangle$ByValue. rec) roundness segments (Color$ByValue. color)))

(defn draw-rectangle-rounded-lines!
  [rec roundness segments linethick color]
  (Raylib/DrawRectangleRoundedLines (Rectangle$ByValue. rec) roundness segments linethick (Color$ByValue. color)))


(defn draw-triangle!
  [v1 v2 v3 color]
  (Raylib/DrawTriangle (Vector2$ByValue. v1) (Vector2$ByValue. v2) (Vector2$ByValue. v3) (Color$ByValue. color)))

(defn draw-triangle-lines!
  [v1 v2 v3 color]
  (Raylib/DrawTriangleLines (Vector2$ByValue. v1) (Vector2$ByValue. v2) (Vector2$ByValue. v3) (Color$ByValue. color)))

;(defn draw-triangle-fan!
  ;[points num-points color]
  ;(Raylib/DrawTriangleFan (Vector2$ByReference. points) num-points (Color$ByValue. color)))

;(defn draw-triangle-strip!
  ;[points num-points color]
  ;(Raylib/DrawTriangleStrip (Vector2$ByReference. points) num-points (Color$ByValue. color)))

(defn draw-poly!
  [center sides radius rotation color]
  (Raylib/DrawPoly (Vector2$ByValue. center) sides radius rotation (Color$ByValue. color)))

(defn draw-poly-lines!
  [center sides radius rotation color]
  (Raylib/DrawPolyLines (Vector2$ByValue. center) sides radius rotation (Color$ByValue. color)))

(defn check-collision-recs?
  [rec1 rec2]
  (Raylib/CheckCollisionRecs (Rectangle$ByValue. rec1) (Rectangle$ByValue. rec2)))

(defn check-collision-circles?
  [center1 radius1 center2 radius2]
  (Raylib/CheckCollisionCircles (Vector2$ByValue. center1) radius1 (Vector2$ByValue. center2) radius2))

(defn check-collision-circle-rec?
  [center radius rec]
  (Raylib/CheckCollisionCircleRec (Vector2$ByValue. center) radius (Rectangle$ByValue. rec)))

(defn get-collision-rec?
  [rec1 rec2]
  (Raylib/GetCollisionRec (Rectangle$ByValue. rec1) (Rectangle$ByValue. rec2)))

(defn check-collision-point-rec?
  [point rec]
  (Raylib/CheckCollisionPointRec (Vector2$ByValue. point) (Rectangle$ByValue. rec)))

(defn check-collision-point-circle?
  [point center radius]
  (Raylib/CheckCollisionPointCircle (Vector2$ByValue. point) (Vector2$ByValue. center) radius))

(defn check-collision-point-triangle?
  [point p1 p2 p3]
  (Raylib/CheckCollisionPointTriangle (Vector2$ByValue. point) (Vector2$ByValue. p1) (Vector2$ByValue. p2) (Vector2$ByValue. p3)))

(defn load-image!
  [file-name]
  (Raylib/LoadImage file-name))

;(defn load-image-ex!
  ;[pixels w h]
  ;(Raylib/LoadImageEx (Color$ByReference. pixels) w h))

(defn load-image-pro!
  [data width height format]
  (Raylib/LoadImagePro data width height format))

(defn load-image-raw!
  [filename w h format header-size]
  (Raylib/LoadImageRaw filename w h format header-size))

(defn unload-image!
  [img]
  (Raylib/UnloadImage (Image$ByValue. img)))

(defn export-image!
  [img filename]
  (Raylib/ExportImage (Image$ByValue. img) filename))

(defn export-image-as-code!
  [img filename]
  (Raylib/ExportImageAsCode (Image$ByValue. img) filename))

(defn get-image-data
  [img]
  (Raylib/GetImageData (Image$ByValue. img)))

(defn get-image-data-normalized
  [img]
  (Raylib/GetImageDataNormalized (Image$ByValue. img)))

(defn gen-image-color
  [w h color]
  (Raylib/GenImageColor w h (Color$ByValue. color)))

(defn gen-image-gradient-v
  [w h top bottom]
  (Raylib/GenImageGradientV w h (Color$ByValue. top) (Color$ByValue. bottom)))

(defn gen-image-gradient-h
  [w h left right]
  (Raylib/GenImageGradientH w h (Color$ByValue. left) (Color$ByValue. right)))

(defn gen-image-gradient-radial
  [w h density inner outer]
  (Raylib/GenImageGradientRadial w h density (Color$ByValue. inner) (Color$ByValue. outer)))

(defn gen-image-checked
  [w h checksx checksy col1 col2]
  (Raylib/GenImageChecked w h checksx checksy (Color$ByValue. col1) (Color$ByValue. col2)))

(defn gen-image-white-noise
  [w h factor]
  (Raylib/GenImageWhiteNoise w h factor))

(defn gen-image-perlin-noise
  [w h offsetx offsety scale]
  (Raylib/GenImagePerlinNoise w h offsetx offsety scale))

(defn gen-image-cellular
  [w h tilesize]
  (Raylib/GenImageCellular w h tilesize))

(defn image-copy
  [img]
  (Raylib/ImageCopy (Image$ByValue. img)))

(defn image-from-image
  [img rec]
  (Raylib/ImageFromImage (Image$ByValue. img) (Rectangle$ByValue. rec)))

(defn image-text
  ([text fontsize color]
   (Raylib/ImageText text fontsize (Color$ByValue. color)))
  ([font text fontsize spacing tint]
   (Raylib/ImageTextEx (Font$ByValue. font) text fontsize spacing (Color$ByValue. tint))))

(defn image-to-pot
  [img fillcolor]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageToPOT new-img (Color$ByValue. fillcolor))
    new-img))


(defn image-format
  [img newformat]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageFormat new-img newformat)
    new-img))

(defn image-alpha-mask
  [img alphamask]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageAlphaMask new-img (Image$ByValue. alphamask))
    new-img))

(defn image-alpha-clear
  [img color threshold]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageAlphaClear new-img (Color$ByValue. color) threshold)
    new-img))

(defn image-alpha-crop
  [img threshold]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageAlphaCrop new-img threshold)
    new-img))

(defn image-alpha-premultiply
  [img]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageAlphaPremultiply new-img)
    new-img))

(defn image-crop
  [img crop]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageCrop new-img (Rectangle$ByValue. crop))
    new-img))

(defn image-resize
  [img new-w new-h]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageResize new-img new-w new-h)
    new-img))

(defn image-resize-nn
  [img new-w new-h]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageResizeNN new-img new-w new-h)
    new-img))

(defn image-resize-canvas
  [img new-w new-h offsetx offsety color]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageResizeCanvas new-img new-w new-h offsetx offsety (Color$ByValue. color))
    new-img
    ))

(defn image-mipmaps
  [img]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageMipmaps new-img)
    new-img))

(defn image-dither
  [img rbpp gbpp bbpp abpp]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageDither new-img rbpp gbpp bbpp abpp)
    new-img))

(defn image-flip-vertical
  [img]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageFlipVertical new-img)
    new-img))

(defn image-flip-horizontal
  [img]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageFlipHorizontal new-img)
    new-img))

(defn image-rotate-cw
  [img]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageRotateCW new-img)
    new-img))

(defn image-rotate-ccw
  [img]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageRotateCCW new-img)
    new-img))

(defn image-color-tint
  [img color]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageColorTint new-img (Color$ByValue. color))
    new-img))

(defn image-color-invert
  [img]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageColorInvert new-img)
    new-img))

(defn image-color-grayscale
  [img]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageColorGrayscale new-img)
    new-img))

(defn image-color-contrast
  [img contrast]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageColorContrast new-img contrast)
    new-img))

(defn image-color-brightness
  [img brightness]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageColorBrightness new-img brightness)
    new-img))

(defn image-color-replace
  [img color replace]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageColorReplace new-img (Color$ByValue. color) (Color$ByValue. color))
    new-img))

(defn image-extract-pallete
  [img maxpalettesize]
  (let [^IntByReference int-ref (IntByReference.)
        ans (Raylib/ImageExtractPalette (Image$ByValue. img) maxpalettesize int-ref)]
    [ans (.getValue int-ref)]))

(defn get-image-alpha-border
  [img threshold]
  (Raylib/GetImageAlphaBorder (Image$ByValue. img) threshold))

(defn image-clear-background
  [img color]
  (let [new-img (Image$ByReference. img)]
    (Raylib/ImageClearBackground new-img (Color$ByValue. color))
    new-img))

(defn image-draw-pixel
  ([dst posx posy color]
   (let [new-img (Image$ByReference. dst)]
     (Raylib/ImageDrawPixel new-img posx posy (Color$ByValue. color))
     new-img))
  ([dst pos color]
   (let [new-img (Image$ByReference. dst)]
     (Raylib/ImageDrawPixelV new-img (Vector2$ByValue. pos) (Color$ByValue. color))
     new-img)))

(defn image-draw-line
  ([dst sposx sposy eposx eposy color]
   (let [new-img (Image$ByReference. dst)]
     (Raylib/ImageDrawLine new-img sposx sposy eposx eposy (Color$ByValue. color))
     new-img))
  ([dst start end color]
   (let [new-img (Image$ByReference. dst)]
     (Raylib/ImageDrawLineV new-img (Vector2$ByValue. start) (Vector2$ByValue. end) (Color$ByValue. color))
     new-img)))

(defn image-draw-circle
  ([dst centerx centery radius color]
   (let [new-img (Image$ByReference. dst)]
     (Raylib/ImageDrawCircle new-img centerx centery radius (Color$ByValue. color))
     new-img))
  ([dst center radius color]
   (let [new-img (Image$ByReference. dst)]
     (Raylib/ImageDrawCircleV new-img (Vector2$ByValue. center) radius (Color$ByValue. color))
     new-img)))

(defn image-draw-rectangle
  ([dst posx posy w h color]
   (let [new-img (Image$ByReference. dst)]
     (Raylib/ImageDrawRectangle new-img posx posy w h (Color$ByValue. color))
     new-img))
  ([dst pos size color]
   (let [new-img (Image$ByReference. dst)]
     (Raylib/ImageDrawRectangleV new-img (Vector2$ByValue. pos) (Vector2$ByValue. size) (Color$ByValue. color))
     new-img))
  ([dst rec color]
   (let [new-img (Image$ByReference. dst)]
     (Raylib/ImageDrawRectangleRec new-img (Rectangle$ByValue. rec) (Color$ByValue. color))
     new-img)))

(defn image-draw-rectangle-lines
  [dst rec thick color]
  (let [new-img (Image$ByReference. dst)]
    (Raylib/ImageDrawRectangleLines new-img (Rectangle$ByValue. rec) thick (Color$ByValue. color))
    new-img))

(defn image-draw
  [dst src src-rec dst-rec tint]
  (let [new-img (Image$ByReference. dst)]
    (Raylib/ImageDraw new-img (Image$ByValue. src) (Rectangle$ByValue. src-rec) (Rectangle$ByValue. dst-rec) (Color$ByValue. tint))
    new-img))

(defn image-draw-text
  ([dst pos text fontsize color]
   (let [new-img (Image$ByReference. dst)]
     (Raylib/ImageDrawText new-img (Vector2$ByValue. pos) text fontsize (Color$ByValue. color))
     new-img))
  ([dst pos font text fontsize spacing color]
   (let [new-img (Image$ByReference. dst)]
     (Raylib/ImageDrawTextEx new-img (Vector2$ByValue. pos) (Font$ByValue. font) text fontsize spacing (Color$ByValue. color))
     new-img)))

(defn load-texture
  [filename]
  (Raylib/LoadTexture filename))

(defn load-texture-from-image
  [img]
  (Raylib/LoadTextureFromImage (Image$ByValue. img)))

(defn load-texture-cubemap
  [img layout-type]
  (Raylib/LoadTextureCubemap (Image$ByValue. img) layout-type))

(defn load-render-texture
  [w h]
  (Raylib/LoadRenderTexture w h))

(defn unload-texture
  [texture]
  (Raylib/UnloadTexture (Texture2D$ByValue. texture)))

(defn unload-render-texture
  [target]
  (Raylib/UnloadRenderTexture (RenderTexture2D$ByValue. target)))

(defn update-texture
  [texture pixels]
  (Raylib/UpdateTexture (Texture2D$ByValue. texture) pixels))

(defn get-texture-data
  [texture]
  (Raylib/GetTextureData (Texture2D$ByValue. texture)))

(defn get-screen-data
  []
  (Raylib/GetScreenData))


(defn gen-texture-mipmaps
  [texture]
  (let [newtexture (Texture2D$ByReference. texture)]
    (Raylib/GenTextureMipmaps newtexture)
    newtexture))

(defn set-texture-filter!
  [texture filtermode]
  (Raylib/SetTextureFilter (Texture2D$ByValue. texture) filtermode))

(defn set-texture-wrap!
  [texture wrapmode]
  (Raylib/SetTextureWrap (Texture2D$ByValue. texture) wrapmode))


(defn draw-texture!
  ([texture posx posy tint]
   (Raylib/DrawTexture (Texture2D$ByValue. texture) posx posy (Color$ByValue. tint)))
  ([texture position tint]
   (Raylib/DrawTextureV (Texture2D$ByValue. texture) (Vector2$ByValue. position) (Color$ByValue. tint)))
  ([texture position rotation scale tint]
   (Raylib/DrawTextureEx (Texture2D$ByValue. texture) (Vector2$ByValue. position) rotation scale (Color$ByValue. tint))))

(defn draw-texture-rec!
  [texture sourcerec position tint]
  (Raylib/DrawTextureRec (Texture2D$ByValue. texture) (Rectangle$ByValue. sourcerec) (Vector2$ByValue. position) (Color$ByValue. tint)))

(defn draw-texture-quad!
  [texture tiling offset quad tint]
  (Raylib/DrawTextureQuad (Texture2D$ByValue. texture) (Vector2$ByValue. tiling) (Vector2$ByValue. offset) 
                          (Rectangle$ByValue. quad) (Color$ByValue. tint)))

(defn draw-texture-pro!
  [texture sourcerec destrec origin rotation tint]
  (Raylib/DrawTexturePro (Texture2D$ByValue. texture) (Rectangle$ByValue. sourcerec) (Rectangle$ByValue. destrec) (Vector2$ByValue. origin) rotation
                         (Color$ByValue. tint)))

(defn draw-texture-npatch!
  [texture npatchinfo destrec origin rotation tint]
  (Raylib/DrawTextureNPatch (Texture2D$ByValue. texture) (NPatchInfo$ByValue. npatchinfo) (Rectangle$ByValue. destrec) (Vector2$ByValue. origin) rotation
                            (Color$ByValue. tint)))

(defn get-pixel-data-size
  [w h format]
  (Raylib/GetPixelDataSize w h format))

(defn draw-text!
  [^String text posx posy size color]
  (Raylib/DrawText text posx posy size color))

