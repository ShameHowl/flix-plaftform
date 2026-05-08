# 📬 AWS SQS Local CLI Cheatsheet (Parameterized)

This document contains parameterized AWS CLI commands for interacting with Amazon SQS in a local environment (LocalStack / Floci).

---

## 🛠️ 0. Setup Variables
**Set QUEUE_NAME** by yourself, then run this block first in your terminal (Git Bash, Zsh, Bash):
```bash
# 🔑 Credentials
export AWS_ACCESS_KEY_ID=test
export AWS_SECRET_ACCESS_KEY=test
export AWS_DEFAULT_REGION=us-east-1

# 🌐 Configuration
export LOCAL_ENDPOINT="http://localhost:4566"
export AWS_REGION="us-east-1"

# 📬 Queue
export QUEUE_NAME="pack-events"
export QUEUE_URL="$LOCAL_ENDPOINT/000000000000/$QUEUE_NAME"

# Verify
echo "Endpoint: $LOCAL_ENDPOINT"
echo "Region: $AWS_REGION"
echo "Queue URL: $QUEUE_URL"
```

---

## 📋 1. List Queues

```bash
aws --endpoint-url $LOCAL_ENDPOINT sqs list-queues \
  --region $AWS_REGION
```

---

## 📤 2. Send Message

```bash
aws --endpoint-url $LOCAL_ENDPOINT sqs send-message \
  --queue-url $QUEUE_URL \
  --message-body "{\"eventId\": \"evt-991\", \"status\": \"COMPLETED\", \"studentId\": \"C2300110\"}" \
  --region $AWS_REGION
```

---

## 📥 3. Receive Message

```bash
aws --endpoint-url $LOCAL_ENDPOINT sqs receive-message \
  --queue-url $QUEUE_URL \
  --max-number-of-messages 10 \
  --wait-time-seconds 5 \
  --region $AWS_REGION
```

---

## 🗑️ 4. Delete Message

```bash
export RECEIPT_HANDLE="PASTE_YOUR_RECEIPT_HANDLE_HERE"

aws --endpoint-url $LOCAL_ENDPOINT sqs delete-message \
  --queue-url $QUEUE_URL \
  --receipt-handle "$RECEIPT_HANDLE" \
  --region $AWS_REGION
```

---

## 📊 5. Get Queue Attributes

```bash
aws --endpoint-url $LOCAL_ENDPOINT sqs get-queue-attributes \
  --queue-url $QUEUE_URL \
  --attribute-names ApproximateNumberOfMessages \
  --region $AWS_REGION
```

---

## 🧹 6. Purge Queue

```bash
aws --endpoint-url $LOCAL_ENDPOINT sqs purge-queue \
  --queue-url $QUEUE_URL \
  --region $AWS_REGION
```

---

## ❌ 7. Delete Queue

```bash
aws --endpoint-url $LOCAL_ENDPOINT sqs delete-queue \
  --queue-url $QUEUE_URL \
  --region $AWS_REGION
```

---

## 💡 Tips

* Use long polling (`wait-time-seconds`) to reduce empty responses
* Messages may be delivered more than once → design for idempotency
* Check logs if issues occur

---

## ✅ Quick Flow

```bash
# 1. Setup
# 2. Send message
# 3. Receive message
# 4. Delete message
```
