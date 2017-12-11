# Introduction

1. 结果导入导出
  - 通过xml文件记录结果
  ```XML
<?xml version="1.0" encoding="UTF-8"?>
<histories>
  <history parameter1="2" operator="+" parameter2="3" result="5" />
  <history parameter1="2" operator="+" parameter2="3" result="5" />
</histories>
  ```
1.  准确的结果
  - 除法支持小数结果
  - 非小数结果无小数位
2. 用户体验问题
  - 当计算完结果后直接按数字，自动clear
  - 当计算完结果后直接按符号，自动将结果设置为parameter1
  - 若已经打开历史窗口，`show History`按钮失效；当历史窗口关闭，按钮恢复
  - 支持删除功能
3. 程序鲁棒性
  - 非法输入可以报错
    - 多运算符
