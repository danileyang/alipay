import ch.qos.logback.classic.PatternLayout
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy
import ch.qos.logback.core.status.OnConsoleStatusListener

scan("3 seconds")
statusListener(OnConsoleStatusListener)
appender("STDOUT", ConsoleAppender) {
    layout(PatternLayout) {
        pattern = "%d %-4relative [%thread] %-5level %logger{35} [Line:%L] - %m%n"
    }
}
appender("FILE", RollingFileAppender) {
    String path = System.getProperty("user.home")
    path = path + "/logs/ddalipay"
    file = path + "/ddalipay.log"
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = path + "/ddalipay.%d{yyyy-MM-dd}.log"
        maxHistory = 10
    }
    layout(PatternLayout) {
        pattern = "%d %-4relative [%thread] %-5level %logger{35} [Line:%L] - %m%n"
    }
}
root(INFO, ["STDOUT", "FILE"])