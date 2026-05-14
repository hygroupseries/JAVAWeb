import os
# 扫描当前工作目录下的项目结构
root = os.getcwd()
print(f"当前工作目录: {root}")
print("\n=== 项目目录结构 ===")
for dirpath, dirnames, filenames in os.walk(root):
    # 跳过一些隐藏目录和缓存
    if '.git' in dirnames:
        dirnames.remove('.git')
    if '__pycache__' in dirnames:
        dirnames.remove('.pycache__')
    if '.mvn' in dirnames:
        dirnames.remove('.mvn')
    # 只显示关键目录和文件
    rel_path = os.path.relpath(dirpath, root)
    if rel_path == '.':
        continue
    depth = rel_path.count(os.sep)
    if depth > 5:
        continue
    prefix = "  " * depth + "├── "
    print(f"{prefix}{os.path.basename(dirpath)}/")
    for f in filenames[:10]:  # 每个目录最多显示10个文件
        print(f"{prefix}  ├── {f}")
    if len(filenames) > 10:
        print(f"{prefix}  └── ... (共{len(filenames)}个文件)")
utils.set_state(success=True, message="项目扫描完成")