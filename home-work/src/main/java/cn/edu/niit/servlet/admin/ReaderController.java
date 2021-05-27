package cn.edu.niit.servlet.admin;

import cn.edu.niit.entity.ReaderInfo;
import cn.edu.niit.service.ReaderService;
import cn.edu.niit.util.SuccessUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping()
public class ReaderController {

    @Autowired
    private ReaderService readerServiece;

    //跳转用户列表界面
    @RequestMapping("/readerIndex")
    public String readerIndex(){
        return "readerIndex";
    }

    //用户列表异步请求
    @RequestMapping("/listReader")
    @ResponseBody
    public String listCategory(@RequestParam(value = "power",defaultValue = "0") Integer power,
                               String readerId, String rname){
        Map<String,Object> paramMap = new HashMap();
        Map<String,Object> map = new HashMap();
        SuccessUtil successUtil=new SuccessUtil();
        //判断是否为空
        if(readerId!=""  && readerId!=null ){
            paramMap.put("readerId",readerId);
        }
        if(rname!=""  && rname!=null ){
            paramMap.put("name",rname);
        }
        List<ReaderInfo> readerInfo = readerServiece.queryList(paramMap);
        System.out.println(readerInfo);
        successUtil.setSuccess(true);
        successUtil.setMessage("查询成功");
        //将pageInfo存入模型
        map.put("data",readerInfo);
        map.put("msg", "成功");
        map.put("code", 0);//这是layui官方文档要求的
        map.put("count", map.size()+1);//这里加1是因为前段是从0开始计数的
        return new JSONObject(map).toString();
    }

    //跳转到新增页面
    @RequestMapping("/addReader")
    public String addreader() {
        return "/reader/addReader";
    }

    //新增用户
    @RequestMapping("/AddReader")
    @ResponseBody
    private SuccessUtil AddReader(ReaderInfo readerInfo){
        SuccessUtil successUtil = new SuccessUtil();
        try{
            int i = readerServiece.addReader(readerInfo);
            if (i>0){
                successUtil.setSuccess(true);
                successUtil.setMessage("新增成功");
            }else {
                successUtil.setSuccess(false);
                successUtil.setMessage("新增失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            successUtil.setSuccess(false);
            successUtil.setMessage("服务器连接失败，请联系客服重试");
        }
        return successUtil;
    }

    //修改页面
    @RequestMapping("/editReader")
    public String editReader(Integer id, Model model) {
        ReaderInfo reader = readerServiece.selectById(id);
        model.addAttribute("reader",reader);
        model.addAttribute("code",1);
        return "/reader/addReader";
    }

    //修改用户信息
    @RequestMapping("/updateReader")
    @ResponseBody
    public SuccessUtil updateReader(ReaderInfo readerInfo) {
        SuccessUtil successUtil = new SuccessUtil();
        try {
            int i = readerServiece.updateReader(readerInfo);
            if (i > 0) {
                successUtil.setSuccess(true);
                successUtil.setMessage("修改成功");
            } else {
                successUtil.setSuccess(false);
                successUtil.setMessage("修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            successUtil.setSuccess(false);
            successUtil.setMessage("服务器连接失败，请联系客服重试");
        }
        return successUtil;
    }

    //显示用户信息
    @RequestMapping("/findReader")
    public String findReader(Integer id,Model model) {
        ReaderInfo reader = readerServiece.selectById(id);
        model.addAttribute("reader",reader);
        return "/reader/addReader";
    }

    //删除用户
    @RequestMapping("/delReader")
    @ResponseBody
    public SuccessUtil delReader(Integer id) {
        SuccessUtil successUtil = new SuccessUtil();
        try {
            int i = readerServiece.delReader(id);
            if (i > 0) {
                successUtil.setSuccess(true);
                successUtil.setMessage("修改成功");
            } else {
                successUtil.setSuccess(false);
                successUtil.setMessage("修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            successUtil.setSuccess(false);
            successUtil.setMessage("服务器连接失败，请联系客服重试");
        }
        return successUtil;
    }

}
