package sing.uiadapter.demo;

import android.app.Activity;
import android.util.DisplayMetrics;

public class MySystemParams {
    private final String TAG = "SystemParams";
    private static MySystemParams params;
    public int screenWidth;// 屏幕宽度，单位为px
    public int screenHeight;// 屏幕高度，单位为px
    public int densityDpi;// 屏幕密度，单位为dpi
    public float scale;// 缩放系数，值为 densityDpi/160
    public float fontScale;// 文字缩放系数，同scale

    public final static int SCREEN_ORIENTATION_VERTICAL = 1; // 屏幕状态：横屏
    public final static int SCREEN_ORIENTATION_HORIZONTAL = 2; // 屏幕状态：竖屏
    public int screenOrientation = SCREEN_ORIENTATION_VERTICAL;// 当前屏幕状态，默认为竖屏

    /**
     * 私有构造方法
     *
     * @param activity
     */
    private MySystemParams(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        densityDpi = dm.densityDpi;
        scale = dm.density;
        fontScale = dm.scaledDensity;

        screenOrientation = screenHeight > screenWidth ? SCREEN_ORIENTATION_VERTICAL
                : SCREEN_ORIENTATION_HORIZONTAL;
    }

    /**
     * 获取实例
     *
     * @param activity
     * @return
     */
    public static MySystemParams getInstance(Activity activity) {
        if (params == null) {
            params = new MySystemParams(activity);
        }
        return params;
    }

    /**
     * 获取一个新实例
     *
     * @param activity
     * @return
     */
    public static MySystemParams getNewInstance(Activity activity) {
        if (params != null) {
            params = null;
        }
        return getInstance(activity);
    }

    /**
     * 参数信息
     */
    public String toString() {
        return TAG
                + ":[screenWidth: "
                + screenWidth
                + " screenHeight: "
                + screenHeight
                + " scale: "
                + scale
                + " fontScale: "
                + fontScale
                + " densityDpi: "
                + densityDpi
                + " screenOrientation: "
                + (screenOrientation == SCREEN_ORIENTATION_VERTICAL ? "vertical"
                : "horizontal") + "]";
    }
}
