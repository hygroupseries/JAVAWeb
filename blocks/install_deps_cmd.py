import subprocess
# 直接调用 uv 命令安装依赖
packages = ['pymysql', 'flask']
print("🚀 正在使用 uv 命令安装依赖...")
try:
    # 调用 uv pip install
    result = subprocess.run(['uv', 'pip', 'install'] + packages, 
                          capture_output=True, text=True, check=True)
    print("✅ 依赖安装成功！")
    if result.stdout:
        print(result.stdout)
except subprocess.CalledProcessError as e:
    print(f"❌ 安装失败：{e}")
    if e.stderr:
        print(e.stderr)
except FileNotFoundError:
    print("❌ 未找到 uv 命令，尝试使用 pip 直接安装...")
    import sys
    result = subprocess.run([sys.executable, '-m', 'pip', 'install'] + packages, 
                          capture_output=True, text=True)
    if result.returncode == 0:
        print("✅ 使用 pip 安装成功！")
    else:
        print(f"❌ pip 安装也失败了：{result.stderr}")