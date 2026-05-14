import os
import shutil
# 定义项目根目录
project_root = "sxdx_employee_web"
dirs = [
    f"{project_root}/src/main/java/com/sxdx/entity",
    f"{project_root}/src/main/java/com/sxdx/util",
    f"{project_root}/src/main/java/com/sxdx/servlet",
    f"{project_root}/src/main/resources",
    f"{project_root}/src/main/webapp",
    f"{project_root}/src/main/webapp/WEB-INF",
]
for d in dirs:
    os.makedirs(d, exist_ok=True)
    print(f"✅ 创建目录：{d}")
utils.set_state(success=True, message="项目目录结构创建完成")