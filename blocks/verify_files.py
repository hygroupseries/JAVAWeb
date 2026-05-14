import os
root = os.getcwd()
print("🔍 验证新增/修改的文件：")
# 验证 src 下的新文件
src_new = os.path.join(root, "src", "javaweb11")
if os.path.exists(src_new):
    print(f"\n📁 src/javaweb11/")
    for f in sorted(os.listdir(src_new)):
        print(f"   ├── {f}")
else:
    print("❌ src/javaweb11/ 不存在")
# 验证 web 下的新页面
web_new = os.path.join(root, "web", "javaweb11")
if os.path.exists(web_new):
    print(f"\n📁 web/javaweb11/")
    for f in sorted(os.listdir(web_new)):
        print(f"   ├── {f}")
else:
    print("❌ web/javaweb11/ 不存在")
# 验证 web.xml 是否包含新配置
web_xml = os.path.join(root, "web", "WEB-INF", "web.xml")
with open(web_xml, 'r', encoding='utf-8') as f:
    content = f.read()
if "javaweb11.RegisterServlet" in content and "javaweb11.LoginServlet" in content:
    print("\n✅ web.xml 已正确配置新 Servlet 映射")
else:
    print("\n❌ web.xml 配置缺失")
# 验证数据库
import pymysql
try:
    conn = pymysql.connect(host='localhost', user='root', password='root', database='sxdxjavaweb', charset='utf8mb4')
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM employee WHERE emp_id='202104041035'")
    row = cursor.fetchone()
    if row:
        print(f"\n✅ 数据库验证通过：{row}")
    cursor.close()
    conn.close()
except Exception as e:
    print(f"\n❌ 数据库验证失败: {e}")
utils.set_state(success=True)