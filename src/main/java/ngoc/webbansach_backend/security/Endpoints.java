package ngoc.webbansach_backend.security;

public class Endpoints {

    public static final String front_end_host = "http://localhost:3000";
    public static final String[] PUBLIC_GET_ENDPOINTS = {
            "/sach",
            "/sach/**",
            "/hinh-anh",
            "/nguoi-dung/search/existsByTenDangNhap",
            "/nguoi-dung/search/existsByEmail",
            "/tai-khoan/kich-hoat",
    };

    public static final String[] PUBLIC_POST_ENDPOINTS = {
            "/tai-khoan/dang-ky",
            "/tai-khoan/dang-nhap"
    };

    public static final String[] USER_GET_ENDPOINTS = {
            "/profile"
    };

    public static final String[] ADMIN_GET_ENDPOINTS = {
            "/nguoi-dung",
            "/nguoi-dung/**",
            "/the-loai",
            "/admin/nguoi-dung",
            "/sach/**"
    };

    public static final String[] ADMIN_POST_ENDPOINTS = {
            "/sach",
            "/hinh-anh",
            "/admin/them-the-loai",
            "/sach/**"
    };

    public static final String[] ADMIN_PUT_ENDPOINTS = {
            "/admin/update-sach/**",
            "/admin/update-the-loai/**",
            "/admin/update-nguoi-dung/**",
            "/sach/**"
    };

    public static final String[] ADMIN_DELETE_ENDPOINTS = {
            "/admin/delete-sach/**",
            "/admin/delete-the-loai/**",
            "/admin/delete-nguoi-dung/**"
    };



}
