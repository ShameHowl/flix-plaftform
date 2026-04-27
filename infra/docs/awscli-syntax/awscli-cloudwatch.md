# 📈 AWS CloudWatch Local CLI Cheatsheet (Parameterized)

This document contains parameterized AWS CLI commands for CloudWatch in a local environment (MiniStack / Floci).

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

# 📊 CloudWatch Logs / Metrics sample values
export LOG_GROUP_NAME="/aws/lambda/example-process-order"
export LOG_STREAM_NAME="give your log stream name here"
export METRIC_NAMESPACE="LocalApp"
export METRIC_NAME="OrdersProcessed"
```

---

## 📝 2. CloudWatch Logs

### List log groups

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" --region "$AWS_REGION" logs describe-log-groups
```

### Search log groups by prefix

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" --region "$AWS_REGION" logs describe-log-groups \
  --log-group-name-prefix "/aws/lambda/"
```

### Tail logs (follow)
> ministack does not support this command yet.

### Tail logs for last 10 minutes (one shot)

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" --region "$AWS_REGION" logs tail "$LOG_GROUP_NAME" --since 10m
```

### List log streams in a log group

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" --region "$AWS_REGION" logs describe-log-streams \
  --log-group-name "$LOG_GROUP_NAME" \
  --order-by LastEventTime \
  --descending
```

### Read log events from a stream

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" --region "$AWS_REGION" logs get-log-events \
  --log-group-name "$LOG_GROUP_NAME" \
  --log-stream-name "$LOG_STREAM_NAME"
```

### Filter log events

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" --region "$AWS_REGION" logs filter-log-events \
  --log-group-name "$LOG_GROUP_NAME" \
  --filter-pattern "hello"
```
---

## 📊 3. CloudWatch Metrics

### Put metric data

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" --region "$AWS_REGION" cloudwatch put-metric-data \
  --namespace "$METRIC_NAMESPACE" \
  --metric-name "$METRIC_NAME" \
  --value 1 \
  --unit Count
```

### List metrics

```bash
aws --endpoint-url "$LOCAL_ENDPOINT" --region "$AWS_REGION" cloudwatch list-metrics \
  --namespace "$METRIC_NAMESPACE"
```

### Get metric statistics

```bash
export START_TIME=$(date -u -d '10 minutes ago' +%Y-%m-%dT%H:%M:%SZ)
export END_TIME=$(date -u +%Y-%m-%dT%H:%M:%SZ)

aws --endpoint-url "$LOCAL_ENDPOINT" --region "$AWS_REGION" cloudwatch get-metric-statistics \
  --namespace "$METRIC_NAMESPACE" \
  --metric-name "$METRIC_NAME" \
  --start-time "$START_TIME" \
  --end-time "$END_TIME" \
  --period 60 \
  --statistics Sum
```

---