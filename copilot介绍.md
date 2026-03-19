# GitHub Copilot 费用与功能介绍

GitHub Copilot 是由 GitHub 和 OpenAI 联合开发的 AI 编程助手，能够在编写代码时提供智能补全、生成代码片段、解释代码，以及通过对话方式协助调试和重构。

---

## 定价方案

### 1. Free（免费版）
- **费用**：$0/月
- **适用人群**：所有 GitHub 用户（包括学生、开源维护者）
- **功能包含**：
  - 每月 2,000 次代码补全
  - 每月 50 次高级模型请求（Premium Requests）
  - 可使用部分高级模型（如 Claude Haiku、GPT-4.1）
  - 支持主流 IDE（VS Code、JetBrains 等）
  - 有限的 Copilot Chat 功能

---

### 2. Pro（专业版）
- **费用**：$10/月 或 $100/年（每用户）
- **适用人群**：个人开发者、自由职业者
- **功能包含**：
  - 无限制标准代码补全
  - 每月 300 次高级模型请求
  - 完整的 Copilot Chat 和 Agent Mode
  - 支持 Claude 3.7、Gemini 2.5 Pro 等高性能模型
  - 支持 VS Code、JetBrains、Visual Studio、Neovim 等主流 IDE
  - 提供 30 天免费试用

---

### 3. Pro+（增强专业版）
- **费用**：$39/月 或 $390/年（每用户）
- **适用人群**：高频使用的资深开发者
- **功能包含**：
  - 包含 Pro 所有功能
  - 每月 1,500 次高级模型请求（是 Pro 版的 5 倍）
  - 可访问所有 AI 模型（包括 OpenAI o3、实验性模型）
  - 优先体验 GitHub Spark 等新特性
  - 无免费试用

---

### 4. Business（商业版）
- **费用**：$19/用户/月
- **适用人群**：中小型团队和企业
- **功能包含**：
  - 包含 Pro 所有功能
  - 每用户每月 300 次高级模型请求
  - 集中账单管理与席位管理
  - SAML SSO 身份验证
  - 内容排除策略与审计日志
  - 组织级使用数据统计
  - IP 赔偿保护；用户代码不用于训练模型

---

### 5. Enterprise（企业版）
- **费用**：$39/用户/月（需要 GitHub Enterprise Cloud）
- **适用人群**：大型企业、对安全和合规有高要求的组织
- **功能包含**：
  - 包含 Business 所有功能
  - 每用户每月 1,000 次高级模型请求
  - 知识库集成（可接入企业内部文档与代码库）
  - 基于内部代码的自定义模型训练
  - 深度 GitHub.com 集成
  - 增强的合规与安全策略

---

## 套餐对比一览

| 功能 | Free | Pro | Pro+ | Business | Enterprise |
|------|------|-----|------|----------|------------|
| 月费 | 免费 | $10 | $39 | $19/用户 | $39/用户 |
| 代码补全 | 2,000次/月 | 无限制 | 无限制 | 无限制 | 无限制 |
| 高级模型请求/月 | 50次 | 300次 | 1,500次 | 300次 | 1,000次 |
| Copilot Chat | 有限 | ✅ | ✅ | ✅ | ✅ |
| Agent Mode | ❌ | ✅ | ✅ | ✅ | ✅ |
| 组织管理 | ❌ | ❌ | ❌ | ✅ | ✅ |
| SAML SSO | ❌ | ❌ | ❌ | ✅ | ✅ |
| 审计日志 | ❌ | ❌ | ❌ | ✅ | ✅ |
| 自定义模型训练 | ❌ | ❌ | ❌ | ❌ | ✅ |
| 知识库集成 | ❌ | ❌ | ❌ | ❌ | ✅ |

---

## 主要功能介绍

### 代码补全（Code Completion）
根据上下文自动补全代码，支持整行、整函数乃至整个代码块的生成，减少重复编码工作。

### Copilot Chat
在 IDE 内与 AI 进行对话，可以：
- 解释代码含义
- 生成测试用例
- 协助调试 Bug
- 重构代码
- 回答编程相关问题

### Agent Mode（智能代理模式）
Copilot 可以自主规划并执行多步骤任务，例如：
- 实现新功能（含创建/修改多个文件）
- 运行测试并根据结果自动修复
- 执行终端命令辅助开发流程

### 多 IDE 支持
- VS Code
- JetBrains 全家桶（IntelliJ IDEA、PyCharm、GoLand 等）
- Visual Studio
- Neovim
- GitHub.com 在线编辑器

### 多语言支持
对 JavaScript、TypeScript、Python、Java、Go、C/C++、C#、Ruby、Rust 等主流编程语言有优秀的支持。

---

## 注意事项

- **Premium Requests（高级模型请求）**：用于 Copilot Chat、Agent Mode 等高级功能。超出套餐额度后，可按 $0.04/次 额外购买。
- **学生与开源维护者**：通过 GitHub Education 认证的学生和热门开源项目的维护者可免费使用 Pro 版功能。
- **隐私保护**：Business 和 Enterprise 版本保证用户代码不会被用于训练 AI 模型。
- **独立订阅**：Copilot 订阅独立于 GitHub 账户类型（Free/Pro/Enterprise），需单独购买。

---

## 官方参考链接

- [GitHub Copilot 官方定价页面](https://github.com/features/copilot/plans)
- [GitHub Copilot 文档](https://docs.github.com/en/copilot)
