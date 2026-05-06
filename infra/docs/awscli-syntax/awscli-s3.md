# 🚀 AWS S3 Local CLI Cheatsheet (Parameterized)

This document contains parameterized AWS CLI commands to interact with Amazon S3 in a local environment (MiniStack / Floci).

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

# 🪣 S3 Bucket Configuration
export BUCKET_NAME="my-s3-bucket"
export OBJECT_KEY="samples/example.json"
```

---

## 📝 2. Bucket Operations

### Create Bucket

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" s3api create-bucket \
  --bucket "$BUCKET_NAME" \
  --region "$AWS_REGION"
```

### List Buckets

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" s3api list-buckets
```

### Check Bucket Exists

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" s3api head-bucket \
  --bucket "$BUCKET_NAME"
```

---

## 📦 3. Object Operations

### Upload Object

```bash
echo '{"status":"ok","source":"local-test"}' > /tmp/example.json

aws --endpoint-url "$LOCAL_ENDPOINT" s3 cp /tmp/example.json "s3://$BUCKET_NAME/$OBJECT_KEY"
```

### List Objects

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" s3 ls "s3://$BUCKET_NAME/" --recursive
```

### Download Object

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" s3 cp "s3://$BUCKET_NAME/$OBJECT_KEY" /tmp/example-downloaded.json
```

### Read Object Metadata

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" s3api head-object \
  --bucket "$BUCKET_NAME" \
  --key "$OBJECT_KEY"
```

---

## 🧹 4. Cleanup

### Delete Object

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" s3 rm "s3://$BUCKET_NAME/$OBJECT_KEY"
```

### Delete Bucket

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" s3 rb "s3://$BUCKET_NAME" --force
```

---

## ✅ Quick Flow

```bash
# 1. Setup variables
# 2. Create bucket
# 3. Upload and verify objects
# 4. Cleanup objects and bucket
```

