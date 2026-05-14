import subprocess
import sys
# 使用 uv pip install 来安装依赖
packages = ['pymysql', 'flask']
print("🚀 正在使用 uv 安装依赖...")
try:
    # 调用 uv pip install
    result = subprocess.run([sys.executable, '-m', 'uv', 'pip', 'install'] + packages, 
                          capture_output=True, text=True, check=True)
    print("✅ 依赖安装成功！")
    print(result.stdout)
except subprocess.CalledProcessError as e:
    print(f"❌ 安装失败：{e}")
    print(e.stderr)
except Exception as e:
    print(f"❌ 发生错误：{e}")