import os
# 创建 web 目录
web_dir = "web"
if not os.path.exists(web_dir):
    os.makedirs(web_dir)
    print(f"目录 {web_dir} 创建成功")
else:
    print(f"目录 {web_dir} 已存在")
utils.set_state(success=True)