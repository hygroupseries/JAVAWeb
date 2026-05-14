import subprocess
import sys
# 使用 uv pip install 安装依赖，这是当前环境推荐的方式
packages = ["mysql-connector-python", "flask"]
for pkg in packages:
    print(f"正在安装 {pkg}...")
    # 尝试使用 uv 安装
    result = subprocess.run(["uv", "pip", "install", pkg], capture_output=True, text=True)
    if result.returncode != 0:
        print(f"uv 安装失败，尝试 pip: {result.stderr}")
        subprocess.check_call([sys.executable, "-m", "pip", "install", pkg])
    else:
        print(f"{pkg} 安装成功")
print("依赖安装完成！")
utils.set_state(success=True)