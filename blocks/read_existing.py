import os
root = os.getcwd()
# 读取现有 web.xml
web_xml_path = os.path.join(root, "web", "WEB-INF", "web.xml")
try:
    with open(web_xml_path, 'r', encoding='utf-8') as f:
        content = f.read()
        print("=== web/WEB-INF/web.xml 内容 ===")
        print(content[:2000])
except Exception as e:
    print(f"读取 web.xml 失败: {e}")
# 读取 jdbc.properties
jdbc_path = os.path.join(root, "src", "jdbc.properties")
try:
    with open(jdbc_path, 'r', encoding='utf-8') as f:
        print("\n=== src/jdbc.properties 内容 ===")
        print(f.read())
except Exception as e:
    print(f"读取 jdbc.properties 失败: {e}")
# 看看已有的 Servlet 包结构
src_dir = os.path.join(root, "src")
for item in os.listdir(src_dir):
    item_path = os.path.join(src_dir, item)
    if os.path.isdir(item_path):
        print(f"\n=== 包目录: {item} ===")
        for f in os.listdir(item_path):
            print(f"  - {f}")
utils.set_state(success=True, message="现有文件读取完成")