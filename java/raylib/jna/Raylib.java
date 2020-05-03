import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.FloatByReference;
import raylib.jna.*;

public class Raylib {

    public static native void InitWindow(int width, int height, String title);  // Initialize window and OpenGL context
    public static native boolean WindowShouldClose();                               // Check if KEY_ESCAPE pressed or Close icon pressed
    public static native void CloseWindow();                                     // Close window and unload OpenGL context
    public static native boolean IsWindowReady();                                   // Check if window has been initialized successfully
    public static native boolean IsWindowMinimized();                               // Check if window has been minimized (or lost focus)
    public static native boolean IsWindowResized();                                 // Check if window has been resized
    public static native boolean IsWindowHidden();                                  // Check if window is currently hidden
    public static native boolean IsWindowFullscreen();                              // Check if window is currently fullscreen
    public static native void ToggleFullscreen();                                // Toggle fullscreen mode (only PLATFORM_DESKTOP)
    public static native void UnhideWindow();                                    // Show the window
    public static native void HideWindow();                                      // Hide the window
    public static native void SetWindowIcon(Image image);                            // Set icon for window (only PLATFORM_DESKTOP)
    public static native void SetWindowTitle(String title);                     // Set title for window (only PLATFORM_DESKTOP)
    public static native void SetWindowPosition(int x, int y);                       // Set window position on screen (only PLATFORM_DESKTOP)
    public static native void SetWindowMonitor(int monitor);                         // Set monitor for the current window (fullscreen mode)
    public static native void SetWindowMinSize(int width, int height);               // Set window minimum dimensions (for FLAG_WINDOW_RESIZABLE)
    public static native void SetWindowSize(int width, int height);                  // Set window dimensions
    public static native Pointer GetWindowHandle();                                // Get native window handle
    public static native int GetScreenWidth();                                   // Get current screen width
    public static native int GetScreenHeight();                                  // Get current screen height
    public static native int GetMonitorCount();                                  // Get number of connected monitors
    public static native int GetMonitorWidth(int monitor);                           // Get primary monitor width
    public static native int GetMonitorHeight(int monitor);                          // Get primary monitor height
    public static native int GetMonitorPhysicalWidth(int monitor);                   // Get primary monitor physical width in millimetres
    public static native int GetMonitorPhysicalHeight(int monitor);                  // Get primary monitor physical height in millimetres
    public static native Vector2 GetWindowPosition();                            // Get window position XY on monitor
    public static native String GetMonitorName(int monitor);                    // Get the human-readable, UTF-8 encoded name of the primary monitor
    public static native String GetClipboardText();                         // Get clipboard text content
    public static native void SetClipboardText(String text);                    // Set clipboard text content

    // Cursor-related functions
    public static native void ShowCursor();                                      // Shows cursor
    public static native void HideCursor();                                      // Hides cursor
    public static native boolean IsCursorHidden();                                  // Check if cursor is not visible
    public static native void EnableCursor();                                    // Enables cursor (unlock cursor)
    public static native void DisableCursor();                                   // Disables cursor (lock cursor)

    // Drawing-related functions
    public static native void ClearBackground(Color color);                          // Set background color (framebuffer clear color)
    public static native void BeginDrawing();                                    // Setup canvas (framebuffer) to start drawing
    public static native void EndDrawing();                                      // End canvas drawing and swap buffers (double buffering)
    public static native void BeginMode2D(Camera2D camera);                          // Initialize 2D mode with custom camera (2D)
    public static native void EndMode2D();                                       // Ends 2D mode with custom camera
    public static native void BeginMode3D(Camera3D camera);                          // Initializes 3D mode with custom camera (3D)
    public static native void EndMode3D();                                       // Ends 3D mode and returns to default 2D orthographic mode
    public static native void BeginTextureMode(RenderTexture2D target);              // Initializes render texture for drawing
    public static native void EndTextureMode();                                  // Ends drawing to render texture
    public static native void BeginScissorMode(int x, int y, int width, int height); // Begin scissor mode (define screen area for following drawing)
    public static native void EndScissorMode();                                  // End scissor mode

    // Screen-space-related functions
    public static native Ray GetMouseRay(Vector2 mousePosition, Camera3D camera);      // Returns a ray trace from mouse position
    public static native Matrix GetCameraMatrix(Camera3D camera);                      // Returns camera transform matrix (view matrix)
    public static native Matrix GetCameraMatrix2D(Camera2D camera);                  // Returns camera 2d transform matrix
    public static native Vector2 GetWorldToScreen(Vector3 position, Camera3D camera);  // Returns the screen space position for a 3d world space position
    public static native Vector2 GetWorldToScreenEx(Vector3 position, Camera3D camera, int width, int height); // Returns size position for a 3d world space position
    public static native Vector2 GetWorldToScreen2D(Vector2 position, Camera2D camera); // Returns the screen space position for a 2d camera world space position
    public static native Vector2 GetScreenToWorld2D(Vector2 position, Camera2D camera); // Returns the world space position for a 2d camera screen space position

    // Timing-related functions
    public static native void SetTargetFPS(int fps);                                 // Set target FPS (maximum)
    public static native int GetFPS();                                           // Returns current FPS
    public static native float GetFrameTime();                                   // Returns time in seconds for last frame drawn
    public static native double GetTime();                                       // Returns elapsed time in seconds since InitWindow()

    // Color-related functions
    public static native int ColorToInt(Color color);                                // Returns hexadecimal value for a Color
    public static native Vector4 ColorNormalize(Color color);                        // Returns color normalized as float [0..1]
    public static native Color ColorFromNormalized(Vector4 normalized);              // Returns color from normalized values [0..1]
    public static native Vector3 ColorToHSV(Color color);                            // Returns HSV values for a Color
    public static native Color ColorFromHSV(Vector3 hsv);                            // Returns a Color from HSV values
    public static native Color GetColor(int hexValue);                               // Returns a Color struct from hexadecimal value
    public static native Color Fade(Color color, float alpha);                       // Color fade-in or fade-out, alpha goes from 0.0f to 1.0f

    // Misc. functions
    public static native void SetConfigFlags(int flags);                    // Setup window configuration flags (view FLAGS)
    public static native void SetTraceLogLevel(int logType);                         // Set the current threshold (minimum) log level
    public static native void SetTraceLogExit(int logType);                          // Set the exit threshold (minimum) log level
    public static native void TakeScreenshot(String fileName);                  // Takes a screenshot of current screen (saved a .png)
    public static native int GetRandomValue(int min, int max);                       // Returns a random value between min and max (both included)

    // Files management functions
    public static native String LoadFileData(String fileName, IntByReference bytesRead);     // Load file data as byte array (read)
    public static native void SaveFileData(String fileName, Pointer data, int bytesToWrite); // Save data to file from byte array (write)
    public static native String LoadFileText(String fileName);                   // Load text data from file (read), returns a '\0' terminated string
    public static native void SaveFileText(String fileName, String text);        // Save text data to file (write), string must be '\0' terminated
    public static native boolean FileExists(String fileName);                      // Check if file exists
    public static native boolean IsFileExtension(String fileName, String ext);// Check file extension
    public static native boolean DirectoryExists(String dirPath);                  // Check if a directory path exists
    public static native String GetExtension(String fileName);             // Get pointer to extension for a filename string
    public static native String GetFileName(String filePath);              // Get pointer to filename for a path string
    public static native String GetFileNameWithoutExt(String filePath);    // Get filename string without extension (uses static string)
    public static native String GetDirectoryPath(String filePath);         // Get full path for a given fileName with path (uses static string)
    public static native String GetPrevDirectoryPath(String dirPath);      // Get previous directory path for a given path (uses static string)
    public static native String GetWorkingDirectory();                      // Get current working directory (uses static string)
    public static native String[] GetDirectoryFiles(String dirPath, IntByReference count);  // Get filenames in a directory path (memory should be freed)
    public static native void ClearDirectoryFiles();                             // Clear directory files paths buffers (free memory)
    public static native boolean ChangeDirectory(String dir);                      // Change working directory, returns true if success
    public static native boolean IsFileDropped();                                   // Check if a file has been dropped into window
    public static native String[] GetDroppedFiles(IntByReference count);                         // Get dropped files names (memory should be freed)
    public static native void ClearDroppedFiles();                               // Clear dropped files paths buffer (free memory)
    public static native long GetFileModTime(String fileName);                  // Get file modification time (last write time)

    public static native String CompressData(String data, int dataLength, IntByReference compDataLength);        // Compress data (DEFLATE algorythm)
    public static native String DecompressData(String compData, int compDataLength, IntByReference dataLength);  // Decompress data (DEFLATE algorythm)

    // Persistent storage management
    public static native void SaveStorageValue(int position, int value);    // Save integer value to storage file (to defined position)
    public static native int LoadStorageValue(int position);                // Load integer value from storage file (from defined position)

    public static native void OpenURL(String url);                              // Open URL with default system browser (if available)

    //------------------------------------------------------------------------------------
    // Input Handling Functions (Module: core)
    //------------------------------------------------------------------------------------

    // Input-related functions: keyboard
    public static native boolean IsKeyPressed(int key);                             // Detect if a key has been pressed once
    public static native boolean IsKeyDown(int key);                                // Detect if a key is being pressed
    public static native boolean IsKeyReleased(int key);                            // Detect if a key has been released once
    public static native boolean IsKeyUp(int key);                                  // Detect if a key is NOT being pressed
    public static native void SetExitKey(int key);                               // Set a custom key to exit program (default is ESC)
    public static native int GetKeyPressed();                                // Get key pressed, call it multiple times for chars queued

    // Input-related functions: gamepads
    public static native boolean IsGamepadAvailable(int gamepad);                   // Detect if a gamepad is available
    public static native boolean IsGamepadName(int gamepad, String name);      // Check gamepad name (if available)
    public static native String GetGamepadName(int gamepad);                // Return gamepad internal name id
    public static native boolean IsGamepadButtonPressed(int gamepad, int button);   // Detect if a gamepad button has been pressed once
    public static native boolean IsGamepadButtonDown(int gamepad, int button);      // Detect if a gamepad button is being pressed
    public static native boolean IsGamepadButtonReleased(int gamepad, int button);  // Detect if a gamepad button has been released once
    public static native boolean IsGamepadButtonUp(int gamepad, int button);        // Detect if a gamepad button is NOT being pressed
    public static native int GetGamepadButtonPressed();                      // Get the last gamepad button pressed
    public static native int GetGamepadAxisCount(int gamepad);                   // Return gamepad axis count for a gamepad
    public static native float GetGamepadAxisMovement(int gamepad, int axis);    // Return axis movement value for a gamepad axis

    // Input-related functions: mouse
    public static native boolean IsMouseButtonPressed(int button);                  // Detect if a mouse button has been pressed once
    public static native boolean IsMouseButtonDown(int button);                     // Detect if a mouse button is being pressed
    public static native boolean IsMouseButtonReleased(int button);                 // Detect if a mouse button has been released once
    public static native boolean IsMouseButtonUp(int button);                       // Detect if a mouse button is NOT being pressed
    public static native int GetMouseX();                                    // Returns mouse position X
    public static native int GetMouseY();                                    // Returns mouse position Y
    public static native Vector2 GetMousePosition();                         // Returns mouse position XY
    public static native void SetMousePosition(int x, int y);                    // Set mouse position XY
    public static native void SetMouseOffset(int offsetX, int offsetY);          // Set mouse offset
    public static native void SetMouseScale(float scaleX, float scaleY);         // Set mouse scaling
    public static native int GetMouseWheelMove();                            // Returns mouse wheel movement Y

    // Input-related functions: touch
    public static native int GetTouchX();                                    // Returns touch position X for touch point 0 (relative to screen size)
    public static native int GetTouchY();                                    // Returns touch position Y for touch point 0 (relative to screen size)
    public static native Vector2 GetTouchPosition(int index);                    // Returns touch position XY for a touch point index (relative to screen size)

    //------------------------------------------------------------------------------------
    // Gestures and Touch Handling Functions (Module: gestures)
    //------------------------------------------------------------------------------------
    public static native void SetGesturesEnabled(int gestureFlags);     // Enable a set of gestures using flags
    public static native boolean IsGestureDetected(int gesture);                    // Check if a gesture have been detected
    public static native int GetGestureDetected();                           // Get latest detected gesture
    public static native int GetTouchPointsCount();                          // Get touch points count
    public static native float GetGestureHoldDuration();                     // Get gesture hold time in milliseconds
    public static native Vector2 GetGestureDragVector();                     // Get gesture drag vector
    public static native float GetGestureDragAngle();                        // Get gesture drag angle
    public static native Vector2 GetGesturePinchVector();                    // Get gesture pinch delta
    public static native float GetGesturePinchAngle();                       // Get gesture pinch angle

    //------------------------------------------------------------------------------------
    // Camera System Functions (Module: camera)
    //------------------------------------------------------------------------------------
    public static native void SetCameraMode(Camera3D camera, int mode);                // Set camera mode (multiple camera modes available)
    public static native void UpdateCamera(Camera3D.ByReference camera);                          // Update camera position for selected mode

    public static native void SetCameraPanControl(int panKey);                       // Set camera pan key to combine with mouse movement (free camera)
    public static native void SetCameraAltControl(int altKey);                       // Set camera alt key to combine with mouse movement (free camera)
    public static native void SetCameraSmoothZoomControl(int szKey);                 // Set camera smooth zoom key to combine with mouse (free camera)
    public static native void SetCameraMoveControls(int frontKey, int backKey, int rightKey, int leftKey, int upKey, int downKey); // Set camera move controls (1st person and 3rd person cameras)

    //------------------------------------------------------------------------------------
    // Basic Shapes Drawing Functions (Module: shapes)
    //------------------------------------------------------------------------------------

    // Basic shapes drawing functions
    public static native void DrawPixel(int posX, int posY, Color color);                                                   // Draw a pixel
    public static native void DrawPixelV(Vector2 position, Color color);                                                    // Draw a pixel (Vector version)
    public static native void DrawLine(int startPosX, int startPosY, int endPosX, int endPosY, Color color);                // Draw a line
    public static native void DrawLineV(Vector2 startPos, Vector2 endPos, Color color);                                     // Draw a line (Vector version)
    public static native void DrawLineEx(Vector2 startPos, Vector2 endPos, float thick, Color color);                       // Draw a line defining thickness
    public static native void DrawLineBezier(Vector2 startPos, Vector2 endPos, float thick, Color color);                   // Draw a line using cubic-bezier curves in-out
    public static native void DrawLineStrip(Vector2.ByReference points, int numPoints, Color color);                                   // Draw lines sequence
    public static native void DrawCircle(int centerX, int centerY, float radius, Color color);                              // Draw a color-filled circle
    public static native void DrawCircleSector(Vector2 center, float radius, int startAngle, int endAngle, int segments, Color color);     // Draw a piece of a circle
    public static native void DrawCircleSectorLines(Vector2 center, float radius, int startAngle, int endAngle, int segments, Color color);    // Draw circle sector outline
    public static native void DrawCircleGradient(int centerX, int centerY, float radius, Color color1, Color color2);       // Draw a gradient-filled circle
    public static native void DrawCircleV(Vector2 center, float radius, Color color);                                       // Draw a color-filled circle (Vector version)
    public static native void DrawCircleLines(int centerX, int centerY, float radius, Color color);                         // Draw circle outline
    public static native void DrawEllipse(int centerX, int centerY, float radiusH, float radiusV, Color color);             // Draw ellipse
    public static native void DrawEllipseLines(int centerX, int centerY, float radiusH, float radiusV, Color color);        // Draw ellipse outline
    public static native void DrawRing(Vector2 center, float innerRadius, float outerRadius, int startAngle, int endAngle, int segments, Color color); // Draw ring
    public static native void DrawRingLines(Vector2 center, float innerRadius, float outerRadius, int startAngle, int endAngle, int segments, Color color);    // Draw ring outline
    public static native void DrawRectangle(int posX, int posY, int width, int height, Color color);                        // Draw a color-filled rectangle
    public static native void DrawRectangleV(Vector2 position, Vector2 size, Color color);                                  // Draw a color-filled rectangle (Vector version)
    public static native void DrawRectangleRec(Rectangle rec, Color color);                                                 // Draw a color-filled rectangle
    public static native void DrawRectanglePro(Rectangle rec, Vector2 origin, float rotation, Color color);                 // Draw a color-filled rectangle with pro parameters
    public static native void DrawRectangleGradientV(int posX, int posY, int width, int height, Color color1, Color color2);// Draw a vertical-gradient-filled rectangle
    public static native void DrawRectangleGradientH(int posX, int posY, int width, int height, Color color1, Color color2);// Draw a horizontal-gradient-filled rectangle
    public static native void DrawRectangleGradientEx(Rectangle rec, Color col1, Color col2, Color col3, Color col4);       // Draw a gradient-filled rectangle with custom vertex colors
    public static native void DrawRectangleLines(int posX, int posY, int width, int height, Color color);                   // Draw rectangle outline
    public static native void DrawRectangleLinesEx(Rectangle rec, int lineThick, Color color);                              // Draw rectangle outline with extended parameters
    public static native void DrawRectangleRounded(Rectangle rec, float roundness, int segments, Color color);              // Draw rectangle with rounded edges
    public static native void DrawRectangleRoundedLines(Rectangle rec, float roundness, int segments, int lineThick, Color color); // Draw rectangle with rounded edges outline
    public static native void DrawTriangle(Vector2 v1, Vector2 v2, Vector2 v3, Color color);                                // Draw a color-filled triangle (vertex in counter-clockwise order!)
    public static native void DrawTriangleLines(Vector2 v1, Vector2 v2, Vector2 v3, Color color);                           // Draw triangle outline (vertex in counter-clockwise order!)
    public static native void DrawTriangleFan(Vector2.ByReference points, int numPoints, Color color);                                 // Draw a triangle fan defined by points (first vertex is the center)
    public static native void DrawTriangleStrip(Vector2.ByReference points, int pointsCount, Color color);                             // Draw a triangle strip defined by points
    public static native void DrawPoly(Vector2 center, int sides, float radius, float rotation, Color color);               // Draw a regular polygon (Vector version)
    public static native void DrawPolyLines(Vector2 center, int sides, float radius, float rotation, Color color);          // Draw a polygon outline of n sides

    // Basic shapes collision detection functions
    public static native boolean CheckCollisionRecs(Rectangle rec1, Rectangle rec2);                                           // Check collision between two rectangles
    public static native boolean CheckCollisionCircles(Vector2 center1, float radius1, Vector2 center2, float radius2);        // Check collision between two circles
    public static native boolean CheckCollisionCircleRec(Vector2 center, float radius, Rectangle rec);                         // Check collision between circle and rectangle
    public static native Rectangle GetCollisionRec(Rectangle rec1, Rectangle rec2);                                         // Get collision rectangle for two rectangles collision
    public static native boolean CheckCollisionPointRec(Vector2 point, Rectangle rec);                                         // Check if point is inside rectangle
    public static native boolean CheckCollisionPointCircle(Vector2 point, Vector2 center, float radius);                       // Check if point is inside circle
    public static native boolean CheckCollisionPointTriangle(Vector2 point, Vector2 p1, Vector2 p2, Vector2 p3);               // Check if point is inside a triangle

    //------------------------------------------------------------------------------------
    // Texture Loading and Drawing Functions (Module: textures)
    //------------------------------------------------------------------------------------

    // Image loading functions
    // NOTE: This functions do not require GPU access
    public static native Image LoadImage(String fileName);                                                             // Load image from file into CPU memory (RAM)
    public static native Image LoadImageEx(Color.ByReference pixels, int width, int height);                                           // Load image from Color array data (RGBA - 32bit)
    public static native Image LoadImagePro(Pointer data, int width, int height, int format);                                 // Load image from raw data with parameters
    public static native Image LoadImageRaw(String fileName, int width, int height, int format, int headerSize);       // Load image from RAW file data
    public static native void UnloadImage(Image image);                                                                     // Unload image from CPU memory (RAM)
    public static native void ExportImage(Image image, String fileName);                                               // Export image data to file
    public static native void ExportImageAsCode(Image image, String fileName);                                         // Export image as code file defining an array of bytes
    public static native Color.ByReference GetImageData(Image image);                                                                  // Get pixel data from image as a Color struct array
    public static native Vector4.ByReference GetImageDataNormalized(Image image);                                                      // Get pixel data from image as Vector4 array (float normalized)

    // Image generation functions
    public static native Image GenImageColor(int width, int height, Color color);                                           // Generate image: plain color
    public static native Image GenImageGradientV(int width, int height, Color top, Color bottom);                           // Generate image: vertical gradient
    public static native Image GenImageGradientH(int width, int height, Color left, Color right);                           // Generate image: horizontal gradient
    public static native Image GenImageGradientRadial(int width, int height, float density, Color inner, Color outer);      // Generate image: radial gradient
    public static native Image GenImageChecked(int width, int height, int checksX, int checksY, Color col1, Color col2);    // Generate image: checked
    public static native Image GenImageWhiteNoise(int width, int height, float factor);                                     // Generate image: white noise
    public static native Image GenImagePerlinNoise(int width, int height, int offsetX, int offsetY, float scale);           // Generate image: perlin noise
    public static native Image GenImageCellular(int width, int height, int tileSize);                                       // Generate image: cellular algorithm. Bigger tileSize means bigger cells

    // Image manipulation functions
    public static native Image ImageCopy(Image image);                                                                      // Create an image duplicate (useful for transformations)
    public static native Image ImageFromImage(Image image, Rectangle rec);                                                  // Create an image from another image piece
    public static native Image ImageText(String text, int fontSize, Color color);                                      // Create an image from text (default font)
    public static native Image ImageTextEx(Font font, String text, float fontSize, float spacing, Color tint);         // Create an image from text (custom sprite font)
    public static native void ImageToPOT(Image.ByReference image, Color fillColor);                                                    // Convert image to POT (power-of-two)
    public static native void ImageFormat(Image.ByReference image, int newFormat);                                                     // Convert image data to desired format
    public static native void ImageAlphaMask(Image.ByReference image, Image alphaMask);                                                // Apply alpha mask to image
    public static native void ImageAlphaClear(Image.ByReference image, Color color, float threshold);                                  // Clear alpha channel to desired color
    public static native void ImageAlphaCrop(Image.ByReference image, float threshold);                                                // Crop image depending on alpha value
    public static native void ImageAlphaPremultiply(Image.ByReference image);                                                          // Premultiply alpha channel
    public static native void ImageCrop(Image.ByReference image, Rectangle crop);                                                      // Crop an image to a defined rectangle
    public static native void ImageResize(Image.ByReference image, int newWidth, int newHeight);                                       // Resize image (Bicubic scaling algorithm)
    public static native void ImageResizeNN(Image.ByReference image, int newWidth,int newHeight);                                      // Resize image (Nearest-Neighbor scaling algorithm)
    public static native void ImageResizeCanvas(Image.ByReference image, int newWidth, int newHeight, int offsetX, int offsetY, Color color);  // Resize canvas and fill with color
    public static native void ImageMipmaps(Image.ByReference image);                                                                   // Generate all mipmap levels for a provided image
    public static native void ImageDither(Image.ByReference image, int rBpp, int gBpp, int bBpp, int aBpp);                            // Dither image data to 16bpp or lower (Floyd-Steinberg dithering)
    public static native void ImageFlipVertical(Image.ByReference image);                                                              // Flip image vertically
    public static native void ImageFlipHorizontal(Image.ByReference image);                                                            // Flip image horizontally
    public static native void ImageRotateCW(Image.ByReference image);                                                                  // Rotate image clockwise 90deg
    public static native void ImageRotateCCW(Image.ByReference image);                                                                 // Rotate image counter-clockwise 90deg
    public static native void ImageColorTint(Image.ByReference image, Color color);                                                    // Modify image color: tint
    public static native void ImageColorInvert(Image.ByReference image);                                                               // Modify image color: invert
    public static native void ImageColorGrayscale(Image.ByReference image);                                                            // Modify image color: grayscale
    public static native void ImageColorContrast(Image.ByReference image, float contrast);                                             // Modify image color: contrast (-100 to 100)
    public static native void ImageColorBrightness(Image.ByReference image, int brightness);                                           // Modify image color: brightness (-255 to 255)
    public static native void ImageColorReplace(Image.ByReference image, Color color, Color replace);                                  // Modify image color: replace color
    public static native Color.ByReference ImageExtractPalette(Image image, int maxPaletteSize, IntByReference extractCount);                    // Extract color palette from image to maximum size (memory should be freed)
    public static native Rectangle GetImageAlphaBorder(Image image, float threshold);                                       // Get image alpha border rectangle

    // Image drawing functions
    // NOTE: Image software-rendering functions (CPU)
    public static native void ImageClearBackground(Image.ByReference dst, Color color);                                                // Clear image background with given color
    public static native void ImageDrawPixel(Image.ByReference dst, int posX, int posY, Color color);                                  // Draw pixel within an image
    public static native void ImageDrawPixelV(Image.ByReference dst, Vector2 position, Color color);                                   // Draw pixel within an image (Vector version)
    public static native void ImageDrawLine(Image.ByReference dst, int startPosX, int startPosY, int endPosX, int endPosY, Color color); // Draw line within an image
    public static native void ImageDrawLineV(Image.ByReference dst, Vector2 start, Vector2 end, Color color);                          // Draw line within an image (Vector version)
    public static native void ImageDrawCircle(Image.ByReference dst, int centerX, int centerY, int radius, Color color);               // Draw circle within an image
    public static native void ImageDrawCircleV(Image.ByReference dst, Vector2 center, int radius, Color color);                        // Draw circle within an image (Vector version)
    public static native void ImageDrawRectangle(Image.ByReference dst, int posX, int posY, int width, int height, Color color);       // Draw rectangle within an image
    public static native void ImageDrawRectangleV(Image.ByReference dst, Vector2 position, Vector2 size, Color color);                 // Draw rectangle within an image (Vector version)
    public static native void ImageDrawRectangleRec(Image.ByReference dst, Rectangle rec, Color color);                                // Draw rectangle within an image 
    public static native void ImageDrawRectangleLines(Image.ByReference dst, Rectangle rec, int thick, Color color);                   // Draw rectangle lines within an image
    public static native void ImageDraw(Image.ByReference dst, Image src, Rectangle srcRec, Rectangle dstRec, Color tint);             // Draw a source image within a destination image (tint applied to source)
    public static native void ImageDrawText(Image.ByReference dst, Vector2 position, String text, int fontSize, Color color);     // Draw text (default font) within an image (destination)
    public static native void ImageDrawTextEx(Image.ByReference dst, Vector2 position, Font font, String text, float fontSize, float spacing, Color color); // Draw text (custom sprite font) within an image (destination)

    // Texture loading functions
    // NOTE: These functions require GPU access
    public static native Texture2D LoadTexture(String fileName);                                                       // Load texture from file into GPU memory (VRAM)
    public static native Texture2D LoadTextureFromImage(Image image);                                                       // Load texture from image data
    public static native Texture2D LoadTextureCubemap(Image image, int layoutType);                                    // Load cubemap from image, multiple image cubemap layouts supported
    public static native RenderTexture2D LoadRenderTexture(int width, int height);                                          // Load texture for rendering (framebuffer)
    public static native void UnloadTexture(Texture2D texture);                                                             // Unload texture from GPU memory (VRAM)
    public static native void UnloadRenderTexture(RenderTexture2D target);                                                  // Unload render texture from GPU memory (VRAM)
    public static native void UpdateTexture(Texture2D texture, Pointer pixels);                                         // Update GPU texture with new data
    public static native Image GetTextureData(Texture2D texture);                                                           // Get pixel data from GPU texture and return an Image
    public static native Image GetScreenData();                                                                         // Get pixel data from screen buffer and return an Image (screenshot)

    // Texture configuration functions
    public static native void GenTextureMipmaps(Texture2D.ByReference texture);                                                        // Generate GPU mipmaps for a texture
    public static native void SetTextureFilter(Texture2D texture, int filterMode);                                          // Set texture scaling filter mode
    public static native void SetTextureWrap(Texture2D texture, int wrapMode);                                              // Set texture wrapping mode

    // Texture drawing functions
    public static native void DrawTexture(Texture2D texture, int posX, int posY, Color tint);                               // Draw a Texture2D
    public static native void DrawTextureV(Texture2D texture, Vector2 position, Color tint);                                // Draw a Texture2D with position defined as Vector2
    public static native void DrawTextureEx(Texture2D texture, Vector2 position, float rotation, float scale, Color tint);  // Draw a Texture2D with extended parameters
    public static native void DrawTextureRec(Texture2D texture, Rectangle sourceRec, Vector2 position, Color tint);         // Draw a part of a texture defined by a rectangle
    public static native void DrawTextureQuad(Texture2D texture, Vector2 tiling, Vector2 offset, Rectangle quad, Color tint);  // Draw texture quad with tiling and offset parameters
    public static native void DrawTexturePro(Texture2D texture, Rectangle sourceRec, Rectangle destRec, Vector2 origin, float rotation, Color tint);       // Draw a part of a texture defined by a rectangle with 'pro' parameters
    public static native void DrawTextureNPatch(Texture2D texture, NPatchInfo nPatchInfo, Rectangle destRec, Vector2 origin, float rotation, Color tint);  // Draws a texture (or part of it) that stretches or shrinks nicely

    // Image/Texture misc functions
    public static native int GetPixelDataSize(int width, int height, int format);                                           // Get pixel data size in bytes (image or texture)

    //------------------------------------------------------------------------------------
    // Font Loading and Text Drawing Functions (Module: text)
    //------------------------------------------------------------------------------------

    // Font loading/unloading functions
    public static native Font GetFontDefault();                                                            // Get the default Font
    public static native Font LoadFont(String fileName);                                                  // Load font from file into GPU memory (VRAM)
    public static native Font LoadFontEx(String fileName, int fontSize, IntByReference fontChars, int charsCount);  // Load font from file with extended parameters
    public static native Font LoadFontFromImage(Image image, Color key, int firstChar);                        // Load font from Image (XNA style)
    public static native CharInfo.ByReference LoadFontData(String fileName, int fontSize, IntByReference fontChars, int charsCount, int type); // Load font data for further use
    public static native Image GenImageFontAtlas(CharInfo.ByReference chars, Rectangle.ByReference[] recs, int charsCount, int fontSize, int padding, int packMethod);  // Generate image font atlas using chars info
    public static native void UnloadFont(Font font);                                                           // Unload Font from GPU memory (VRAM)

    // Text drawing functions
    public static native void DrawFPS(int posX, int posY);                                                     // Shows current FPS
    public static native void DrawText(String text, int posX, int posY, int fontSize, Color color);       // Draw text (using default font)
    public static native void DrawTextEx(Font font, String text, Vector2 position, float fontSize, float spacing, Color tint);                // Draw text using font and additional parameters
    public static native void DrawTextRec(Font font, String text, Rectangle rec, float fontSize, float spacing, boolean wordWrap, Color tint);   // Draw text using font inside rectangle limits
    public static native void DrawTextRecEx(Font font, String text, Rectangle rec, float fontSize, float spacing, boolean wordWrap, Color tint,
            int selectStart, int selectLength, Color selectTint, Color selectBackTint); // Draw text using font inside rectangle limits with support for text selection
    public static native void DrawTextCodepoint(Font font, int codepoint, Vector2 position, float scale, Color tint);   // Draw one character (codepoint)

    // Text misc. functions
    public static native int MeasureText(String text, int fontSize);                                      // Measure string width for default font
    public static native Vector2 MeasureTextEx(Font font, String text, float fontSize, float spacing);    // Measure string size for Font
    public static native int GetGlyphIndex(Font font, int codepoint);                                          // Get index position for a unicode character on font

    // Text strings management functions (no utf8 strings, only byte chars)
    // NOTE: Some strings allocate memory internally for returned strings, just be careful!
    public static native int TextCopy(String dst, String src);                                             // Copy one string to another, returns bytes copied
    public static native boolean TextIsEqual(String text1, String text2);                               // Check if two text string are equal
    public static native int TextLength(String text);                                            // Get text length, checks for '\0' ending
    public static native String TextSubtext(String text, int position, int length);                  // Get a piece of a text string
    public static native String TextReplace(String text, String replace, String by);                   // Replace text string (memory must be freed!)
    public static native String TextInsert(String text, String insert, int position);                 // Insert text in a position (memory must be freed!)
    public static native String TextJoin(String[] textList, int count, String delimiter);        // Join text strings with delimiter
    public static native String[] TextSplit(String text, char delimiter, IntByReference count);                 // Split text into multiple strings
    public static native void TextAppend(String text, String append, IntByReference position);                       // Append text at specific position and move cursor!
    public static native int TextFindIndex(String text, String find);                                // Find first text occurrence within a string
    public static native String TextToUpper(String text);                      // Get upper case version of provided string
    public static native String TextToLower(String text);                      // Get lower case version of provided string
    public static native String TextToPascal(String text);                     // Get Pascal case notation version of provided string
    public static native int TextToInteger(String text);                            // Get integer value from text (negative values not supported)
    public static native String TextToUtf8(IntByReference codepoints, int length);                  // Encode text codepoint into utf8 text (memory must be freed!)

    // UTF8 text strings management functions
    public static native IntByReference GetCodepoints(String text, IntByReference count);               // Get all codepoints in a string, codepoints count returned by parameters
    public static native int GetCodepointsCount(String text);                       // Get total number of characters (codepoints) in a UTF8 encoded string
    public static native int GetNextCodepoint(String text, IntByReference bytesProcessed);    // Returns next codepoint in a UTF8 encoded string; 0x3f('?') is returned on failure
    public static native String CodepointToUtf8(int codepoint, IntByReference byteLength);    // Encode codepoint into utf8 text (char array length returned as parameter)

    //------------------------------------------------------------------------------------
    // Basic 3d Shapes Drawing Functions (Module: models)
    //------------------------------------------------------------------------------------

    // Basic geometric 3D shapes drawing functions
    public static native void DrawLine3D(Vector3 startPos, Vector3 endPos, Color color);                                    // Draw a line in 3D world space
    public static native void DrawPoint3D(Vector3 position, Color color);                                                   // Draw a point in 3D space, actually a small line
    public static native void DrawCircle3D(Vector3 center, float radius, Vector3 rotationAxis, float rotationAngle, Color color); // Draw a circle in 3D world space
    public static native void DrawCube(Vector3 position, float width, float height, float length, Color color);             // Draw cube
    public static native void DrawCubeV(Vector3 position, Vector3 size, Color color);                                       // Draw cube (Vector version)
    public static native void DrawCubeWires(Vector3 position, float width, float height, float length, Color color);        // Draw cube wires
    public static native void DrawCubeWiresV(Vector3 position, Vector3 size, Color color);                                  // Draw cube wires (Vector version)
    public static native void DrawCubeTexture(Texture2D texture, Vector3 position, float width, float height, float length, Color color); // Draw cube textured
    public static native void DrawSphere(Vector3 centerPos, float radius, Color color);                                     // Draw sphere
    public static native void DrawSphereEx(Vector3 centerPos, float radius, int rings, int slices, Color color);            // Draw sphere with extended parameters
    public static native void DrawSphereWires(Vector3 centerPos, float radius, int rings, int slices, Color color);         // Draw sphere wires
    public static native void DrawCylinder(Vector3 position, float radiusTop, float radiusBottom, float height, int slices, Color color); // Draw a cylinder/cone
    public static native void DrawCylinderWires(Vector3 position, float radiusTop, float radiusBottom, float height, int slices, Color color); // Draw a cylinder/cone wires
    public static native void DrawPlane(Vector3 centerPos, Vector2 size, Color color);                                      // Draw a plane XZ
    public static native void DrawRay(Ray ray, Color color);                                                                // Draw a ray line
    public static native void DrawGrid(int slices, float spacing);                                                          // Draw a grid (centered at (0, 0, 0))
    public static native void DrawGizmo(Vector3 position);                                                                  // Draw simple gizmo
    //DrawTorus(), DrawTeapot() could be useful?

    //------------------------------------------------------------------------------------
    // Model 3d Loading and Drawing Functions (Module: models)
    //------------------------------------------------------------------------------------

    // Model loading/unloading functions
    public static native Model LoadModel(String fileName);                                                            // Load model from files (meshes and materials)
    public static native Model LoadModelFromMesh(Mesh mesh);                                                               // Load model from generated mesh (default material)
    public static native void UnloadModel(Model model);                                                                    // Unload model from memory (RAM and/or VRAM)

    // Mesh loading/unloading functions
    public static native Mesh.ByReference LoadMeshes(String fileName, IntByReference meshCount);                                           // Load meshes from model file
    public static native void ExportMesh(Mesh mesh, String fileName);                                                 // Export mesh data to file
    public static native void UnloadMesh(Mesh mesh);                                                                       // Unload mesh from memory (RAM and/or VRAM)

    // Material loading/unloading functions
    public static native Material.ByReference LoadMaterials(String fileName, IntByReference materialCount);                                // Load materials from model file
    public static native Material LoadMaterialDefault();                                                               // Load default material (Supports: DIFFUSE, SPECULAR, NORMAL maps)
    public static native void UnloadMaterial(Material material);                                                           // Unload material from GPU memory (VRAM)
    public static native void SetMaterialTexture(Material.ByReference material, int mapType, Texture2D texture);                      // Set texture for a material map type (MAP_DIFFUSE, MAP_SPECULAR...)
    public static native void SetModelMeshMaterial(Model.ByReference model, int meshId, int materialId);                              // Set material for a mesh

    // Model animations loading/unloading functions
    public static native ModelAnimation.ByReference LoadModelAnimations(String fileName, IntByReference animsCount);                       // Load model animations from file
    public static native void UpdateModelAnimation(Model model, ModelAnimation anim, int frame);                           // Update model animation pose
    public static native void UnloadModelAnimation(ModelAnimation anim);                                                   // Unload animation data
    public static native boolean IsModelAnimationValid(Model model, ModelAnimation anim);                                     // Check model animation skeleton match

    // Mesh generation functions
    public static native Mesh GenMeshPoly(int sides, float radius);                                                        // Generate polygonal mesh
    public static native Mesh GenMeshPlane(float width, float length, int resX, int resZ);                                 // Generate plane mesh (with subdivisions)
    public static native Mesh GenMeshCube(float width, float height, float length);                                        // Generate cuboid mesh
    public static native Mesh GenMeshSphere(float radius, int rings, int slices);                                          // Generate sphere mesh (standard sphere)
    public static native Mesh GenMeshHemiSphere(float radius, int rings, int slices);                                      // Generate half-sphere mesh (no bottom cap)
    public static native Mesh GenMeshCylinder(float radius, float height, int slices);                                     // Generate cylinder mesh
    public static native Mesh GenMeshTorus(float radius, float size, int radSeg, int sides);                               // Generate torus mesh
    public static native Mesh GenMeshKnot(float radius, float size, int radSeg, int sides);                                // Generate trefoil knot mesh
    public static native Mesh GenMeshHeightmap(Image heightmap, Vector3 size);                                             // Generate heightmap mesh from image data
    public static native Mesh GenMeshCubicmap(Image cubicmap, Vector3 cubeSize);                                           // Generate cubes-based map mesh from image data

    // Mesh manipulation functions
    public static native BoundingBox MeshBoundingBox(Mesh mesh);                                                           // Compute mesh bounding box limits
    public static native void MeshTangents(Mesh.ByReference mesh);                                                                    // Compute mesh tangents
    public static native void MeshBinormals(Mesh.ByReference mesh);                                                                   // Compute mesh binormals

    // Model drawing functions
    public static native void DrawModel(Model model, Vector3 position, float scale, Color tint);                           // Draw a model (with texture if set)
    public static native void DrawModelEx(Model model, Vector3 position, Vector3 rotationAxis, float rotationAngle, Vector3 scale, Color tint); // Draw a model with extended parameters
    public static native void DrawModelWires(Model model, Vector3 position, float scale, Color tint);                      // Draw a model wires (with texture if set)
    public static native void DrawModelWiresEx(Model model, Vector3 position, Vector3 rotationAxis, float rotationAngle, Vector3 scale, Color tint); // Draw a model wires (with texture if set) with extended parameters
    public static native void DrawBoundingBox(BoundingBox box, Color color);                                               // Draw bounding box (wires)
    public static native void DrawBillboard(Camera3D camera, Texture2D texture, Vector3 center, float size, Color tint);     // Draw a billboard texture
    public static native void DrawBillboardRec(Camera3D camera, Texture2D texture, Rectangle sourceRec, Vector3 center, float size, Color tint); // Draw a billboard texture defined by sourceRec

    // Collision detection functions
    public static native boolean CheckCollisionSpheres(Vector3 centerA, float radiusA, Vector3 centerB, float radiusB);       // Detect collision between two spheres
    public static native boolean CheckCollisionBoxes(BoundingBox box1, BoundingBox box2);                                     // Detect collision between two bounding boxes
    public static native boolean CheckCollisionBoxSphere(BoundingBox box, Vector3 center, float radius);                      // Detect collision between box and sphere
    public static native boolean CheckCollisionRaySphere(Ray ray, Vector3 center, float radius);                              // Detect collision between ray and sphere
    public static native boolean CheckCollisionRaySphereEx(Ray ray, Vector3 center, float radius, Vector3.ByReference collisionPoint);   // Detect collision between ray and sphere, returns collision point
    public static native boolean CheckCollisionRayBox(Ray ray, BoundingBox box);                                              // Detect collision between ray and box
    public static native RayHitInfo GetCollisionRayModel(Ray ray, Model model);                                            // Get collision info between ray and model
    public static native RayHitInfo GetCollisionRayTriangle(Ray ray, Vector3 p1, Vector3 p2, Vector3 p3);                  // Get collision info between ray and triangle
    public static native RayHitInfo GetCollisionRayGround(Ray ray, float groundHeight);                                    // Get collision info between ray and ground plane (Y-normal plane)

    //------------------------------------------------------------------------------------
    // Shaders System Functions (Module: rlgl)
    // NOTE: This functions are useless when using OpenGL 1.1
    //------------------------------------------------------------------------------------

    // Shader loading/unloading functions
    public static native Shader LoadShader(String vsFileName, String fsFileName);  // Load shader from files and bind default locations
    public static native Shader LoadShaderCode(String vsCode, String fsCode);      // Load shader from code strings and bind default locations
    public static native void UnloadShader(Shader shader);                                   // Unload shader from GPU memory (VRAM)

    public static native Shader GetShaderDefault();                                      // Get default shader
    public static native Texture2D GetTextureDefault();                                  // Get default texture
    public static native Texture2D GetShapesTexture();                                   // Get texture to draw shapes
    public static native Rectangle GetShapesTextureRec();                                // Get texture rectangle to draw shapes
    public static native void SetShapesTexture(Texture2D texture, Rectangle source);         // Define default texture used to draw shapes

    // Shader configuration functions
    public static native int GetShaderLocation(Shader shader, String uniformName);      // Get shader uniform location
    public static native void SetShaderValue(Shader shader, int uniformLoc, Pointer value, int uniformType);               // Set shader uniform value
    public static native void SetShaderValueV(Shader shader, int uniformLoc, Pointer value, int uniformType, int count);   // Set shader uniform value vector
    public static native void SetShaderValueMatrix(Shader shader, int uniformLoc, Matrix mat);         // Set shader uniform value (matrix 4x4)
    public static native void SetShaderValueTexture(Shader shader, int uniformLoc, Texture2D texture); // Set shader uniform value for texture
    public static native void SetMatrixProjection(Matrix proj);                              // Set a custom projection matrix (replaces internal projection matrix)
    public static native void SetMatrixModelview(Matrix view);                               // Set a custom modelview matrix (replaces internal modelview matrix)
    public static native Matrix GetMatrixModelview();                                    // Get internal modelview matrix
    public static native Matrix GetMatrixProjection();                                   // Get internal projection matrix

    // Texture maps generation (PBR)
    // NOTE: Required shaders should be provided
    public static native Texture2D GenTextureCubemap(Shader shader, Texture2D map, int size);          // Generate cubemap texture from 2D texture
    public static native Texture2D GenTextureIrradiance(Shader shader, Texture2D cubemap, int size);   // Generate irradiance texture using cubemap data
    public static native Texture2D GenTexturePrefilter(Shader shader, Texture2D cubemap, int size);    // Generate prefilter texture using cubemap data
    public static native Texture2D GenTextureBRDF(Shader shader, int size);                  // Generate BRDF texture

    // Shading begin/end functions
    public static native void BeginShaderMode(Shader shader);                                // Begin custom shader drawing
    public static native void EndShaderMode();                                           // End custom shader drawing (use default shader)
    public static native void BeginBlendMode(int mode);                                      // Begin blending mode (alpha, additive, multiplied)
    public static native void EndBlendMode();                                            // End blending mode (reset to default: alpha blending)

    // VR control functions
    public static native void InitVrSimulator();                       // Init VR simulator for selected device parameters
    public static native void CloseVrSimulator();                      // Close VR simulator for current device
    public static native void UpdateVrTracking(Camera3D.ByReference camera);            // Update VR tracking (position and orientation) and camera
    public static native void SetVrConfiguration(VrDeviceInfo info, Shader distortion);      // Set stereo rendering configuration parameters
    public static native boolean IsVrSimulatorReady();                    // Detect if VR simulator is ready
    public static native void ToggleVrMode();                          // Enable/Disable VR experience
    public static native void BeginVrDrawing();                        // Begin VR simulator stereo rendering
    public static native void EndVrDrawing();                          // End VR simulator stereo rendering

    //------------------------------------------------------------------------------------
    // Audio Loading and Playing Functions (Module: audio)
    //------------------------------------------------------------------------------------

    // Audio device management functions
    public static native void InitAudioDevice();                                     // Initialize audio device and context
    public static native void CloseAudioDevice();                                    // Close the audio device and context
    public static native boolean IsAudioDeviceReady();                                  // Check if audio device has been initialized successfully
    public static native void SetMasterVolume(float volume);                             // Set master volume (listener)

    // Wave/Sound loading/unloading functions
    public static native Wave LoadWave(String fileName);                            // Load wave data from file
    public static native Sound LoadSound(String fileName);                          // Load sound from file
    public static native Sound LoadSoundFromWave(Wave wave);                             // Load sound from wave data
    public static native void UpdateSound(Sound sound, Pointer data, int samplesCount);// Update sound buffer with new data
    public static native void UnloadWave(Wave wave);                                     // Unload wave data
    public static native void UnloadSound(Sound sound);                                  // Unload sound
    public static native void ExportWave(Wave wave, String fileName);               // Export wave data to file
    public static native void ExportWaveAsCode(Wave wave, String fileName);         // Export wave sample data to code (.h)

    // Wave/Sound management functions
    public static native void PlaySound(Sound sound);                                    // Play a sound
    public static native void StopSound(Sound sound);                                    // Stop playing a sound
    public static native void PauseSound(Sound sound);                                   // Pause a sound
    public static native void ResumeSound(Sound sound);                                  // Resume a paused sound
    public static native void PlaySoundMulti(Sound sound);                               // Play a sound (using multichannel buffer pool)
    public static native void StopSoundMulti();                                      // Stop any sound playing (using multichannel buffer pool)
    public static native int GetSoundsPlaying();                                     // Get number of sounds playing in the multichannel
    public static native boolean IsSoundPlaying(Sound sound);                               // Check if a sound is currently playing
    public static native void SetSoundVolume(Sound sound, float volume);                 // Set volume for a sound (1.0 is max level)
    public static native void SetSoundPitch(Sound sound, float pitch);                   // Set pitch for a sound (1.0 is base level)
    public static native void WaveFormat(Wave.ByReference wave, int sampleRate, int sampleSize, int channels);  // Convert wave data to desired format
    public static native Wave WaveCopy(Wave wave);                                       // Copy a wave to a new wave
    public static native void WaveCrop(Wave.ByReference wave, int initSample, int finalSample);     // Crop a wave to defined samples range
    public static native FloatByReference GetWaveData(Wave wave);                                  // Get samples data from wave as a floats array

    // Music management functions
    public static native Music LoadMusicStream(String fileName);                    // Load music stream from file
    public static native void UnloadMusicStream(Music music);                            // Unload music stream
    public static native void PlayMusicStream(Music music);                              // Start music playing
    public static native void UpdateMusicStream(Music music);                            // Updates buffers for music streaming
    public static native void StopMusicStream(Music music);                              // Stop music playing
    public static native void PauseMusicStream(Music music);                             // Pause music playing
    public static native void ResumeMusicStream(Music music);                            // Resume playing paused music
    public static native boolean IsMusicPlaying(Music music);                               // Check if music is playing
    public static native void SetMusicVolume(Music music, float volume);                 // Set volume for music (1.0 is max level)
    public static native void SetMusicPitch(Music music, float pitch);                   // Set pitch for a music (1.0 is base level)
    public static native void SetMusicLoopCount(Music music, int count);                 // Set music loop count (loop repeats)
    public static native float GetMusicTimeLength(Music music);                          // Get music time length (in seconds)
    public static native float GetMusicTimePlayed(Music music);                          // Get current music time played (in seconds)

    // AudioStream management functions
    public static native AudioStream InitAudioStream(int sampleRate, int sampleSize, int channels); // Init audio stream (to stream raw audio pcm data)
    public static native void UpdateAudioStream(AudioStream stream, Pointer data, int samplesCount); // Update audio stream buffers with data
    public static native void CloseAudioStream(AudioStream stream);                      // Close audio stream and free memory
    public static native boolean IsAudioStreamProcessed(AudioStream stream);                // Check if any audio stream buffers requires refill
    public static native void PlayAudioStream(AudioStream stream);                       // Play audio stream
    public static native void PauseAudioStream(AudioStream stream);                      // Pause audio stream
    public static native void ResumeAudioStream(AudioStream stream);                     // Resume audio stream
    public static native boolean IsAudioStreamPlaying(AudioStream stream);                  // Check if audio stream is playing
    public static native void StopAudioStream(AudioStream stream);                       // Stop audio stream
    public static native void SetAudioStreamVolume(AudioStream stream, float volume);    // Set volume for audio stream (1.0 is max level)
    public static native void SetAudioStreamPitch(AudioStream stream, float pitch);      // Set pitch for audio stream (1.0 is base level)
    public static native void SetAudioStreamBufferSizeDefault(int size);                 // Default size for new audio streams

    static {
        Native.register("libraylib.so.3.0.0");
    }
}
