# 🚀 AWS Parameter Store (SSM) Local CLI Cheatsheet (Parameterized)

This document contains parameterized AWS CLI commands to interact with AWS Systems Manager Parameter Store in a local environment (MiniStack / Floci).

---

## 🛠️ 1. Setup Variables
Run this block first in your terminal (Git Bash, Zsh, Bash):

```bash
# 🔑 Credentials for local emulator
export AWS_ACCESS_KEY_ID=test
export AWS_SECRET_ACCESS_KEY=test
export AWS_DEFAULT_REGION=us-east-1

# 🌐 Infrastructure Configuration
export LOCAL_ENDPOINT="http://localhost:4566"
export AWS_REGION="us-east-1"

# 🧩 Parameter Configuration
export SERVICE_NAME="example-service"
export PARAM_NAME="/$SERVICE_NAME/database.url"
export PARAM_VALUE="jdbc:postgresql://localhost:5432/inventory_db"

export SECURE_PARAM_NAME="/$SERVICE_NAME/api.secret-key"
export SECURE_PARAM_VALUE="super-secret-local-token"
```

---

## 📝 2. Put Parameters

### Put String Parameter

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" ssm put-parameter \
  --name "$PARAM_NAME" \
  --value "$PARAM_VALUE" \
  --type "String" \
  --overwrite \
  --region "$AWS_REGION"
```

### Put SecureString Parameter

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" ssm put-parameter \
  --name "$SECURE_PARAM_NAME" \
  --value "$SECURE_PARAM_VALUE" \
  --type "SecureString" \
  --overwrite \
  --region "$AWS_REGION"
```

---

## 🔎 3. Read Parameters

### Get One Parameter

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" ssm get-parameter \
  --name "$PARAM_NAME" \
  --region "$AWS_REGION"
```

### Get Secure Parameter (decrypted)

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" ssm get-parameter \
  --name "$SECURE_PARAM_NAME" \
  --with-decryption \
  --region "$AWS_REGION"
```

### Get Parameters by Path

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" ssm get-parameters-by-path \
  --path "/$SERVICE_NAME" \
  --recursive \
  --with-decryption \
  --region "$AWS_REGION"
```

---

## 🧹 4. Delete Parameters

### Delete One Parameter

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" ssm delete-parameter \
  --name "$PARAM_NAME" \
  --region "$AWS_REGION"
```

### Delete Multiple Parameters

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" ssm delete-parameters \
  --names "$SECURE_PARAM_NAME" "/$SERVICE_NAME/database.password" \
  --region "$AWS_REGION"
```

---

## ✅ Quick Flow

```bash
# 1. Setup variables
# 2. Put String/SecureString parameters
# 3. Read parameters by name/path
# 4. Delete parameters when done
```
