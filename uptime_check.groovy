
rebati_gcp1@cloudshell:~/terraform_code/projects/178448763912/MonitoringAlertPolicy (gcp-demo-427606)$ gcloud beta resource-config bulk-export \
  --project=gcp-demo-427606 \
  --resource-format=terraform
Exporting resource configurations to stdout...




resource "google_monitoring_alert_policy" "15335139469652812793" {
  combiner = "OR"
  conditions {
    condition_threshold {
      aggregations {
        alignment_period     = "1200s"
        cross_series_reducer = "REDUCE_COUNT_FALSE"
        group_by_fields      = ["resource.label.*"]
        per_series_aligner   = "ALIGN_NEXT_OLDER"
      }
      comparison      = "COMPARISON_GT"
      duration        = "60s"
      filter          = "metric.type=\"monitoring.googleapis.com/uptime_check/check_passed\" AND metric.label.check_id=\"ssc-gov-site-is-down-g7yEP20NXV4\" AND resource.type=\"uptime_url\""
      threshold_value = 1
      trigger {
        count = 1
      }
    }
    display_name = "Failure of uptime check_id ssc-gov-site-is-down-g7yEP20NXV4"
  }
  display_name          = "SSC GOV Site is Down uptime failure"
  enabled               = true
  notification_channels = ["projects/gcp-demo-427606/notificationChannels/11632704460311689461"]
  project               = "178448763912"
}

# terraform import google_monitoring_alert_policy.15335139469652812793 178448763912 projects/178448763912/alertPolicies/15335139469652812793


resource "google_monitoring_notification_channel" "rebatigcp" {
  display_name = "rebatigcp"
  enabled      = true
  labels = {
    email_address = "rebati.gcp1@gmail.com"
  }
  project = "gcp-demo-427606"
  type    = "email"
}

# terraform import google_monitoring_notification_channel.rebatigcp gcp-demo-427606 projects/gcp-demo-427606/notificationChannels/11632704460311689461
