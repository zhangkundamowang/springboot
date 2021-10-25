//package com.zk.springboot.modular.controller;
//
//
//import com.zk.springboot.common.response.Response;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//
///**
// * 测试像服务器传送文件
// */
//@RestController
//@RequestMapping("/test")
//public class SysUserRoleController {
//
//    @PostMapping(value = "uploadImg")
//    @ResponseBody
//    public Object uploadImg(MultipartFile[] files){
//        return new Response(service.uploadImage(files));
//    }
//
//}
