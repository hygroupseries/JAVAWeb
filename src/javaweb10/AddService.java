package javaweb10;
/*
    Service层：业务/服务层
    负责功能模块的业务逻辑实现
 */
public class AddService {

    //获取dao层的对象
    private AddDao addDao = new AddDao();

    public String add(int sid,String sname,String gender){
        String msg = "";

        if(!addDao.selectBySid(sid)){
            //执行插入操作
            addDao.insert(sid, sname, gender);
            msg = "学生添加成功~";
        }else {
            msg = "学生已存在，添加失败~";
        }
        return msg;
    }

}
