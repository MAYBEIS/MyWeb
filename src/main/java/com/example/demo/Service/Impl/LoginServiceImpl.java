package com.example.demo.Service.Impl;

import com.example.demo.Constant.ExceptionConstant;
import com.example.demo.Constant.SystemConstant;
import com.example.demo.Domain.LoginUser;
import com.example.demo.Domain.ResponseResult;
import com.example.demo.Service.LoginService;
import com.example.demo.Util.BeanCopyUtils;
import com.example.demo.Util.JwtUtil;
import com.example.demo.Util.RedisCache;
import com.example.demo.Vo.UserInfoVo;
import com.example.demo.Vo.UserLoginVo;
import com.example.demo.generator.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Objects;



@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //判断是否认证通过
        if(Objects.isNull(authenticate)){
            throw new RuntimeException(ExceptionConstant.USER_LOGIN_FAIL);
        }
        //获取userid 生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        loginUser.setJwt(jwt);

        //把用户信息存入redis
        redisCache.setCacheObject(SystemConstant.REDIS_JWT_SUFFIX + userId,loginUser);

        //把token和userinfo封装 返回
        //把User转换成UserInfoVo
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(loginUser.getUser(), UserInfoVo.class);
        UserLoginVo vo = new UserLoginVo(jwt,userInfoVo);

        return ResponseResult.okResult(vo);
    }
}
