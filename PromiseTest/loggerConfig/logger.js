/**
 * Created by anavarro on 9/7/14.
 */
var log4js = require('log4js')
log4js.configure({
    appenders: [
        {
            type: 'console'
        },
        {
            'type': 'file',
            'category': 'test-logger',
            'filename': './logs/log_file.log',
            maxLogSize: 10240,
            backups: 3,
            layout: {
                type: "pattern",
                pattern: "[%d{MM/dd/yyyy hh:mm:ss}] %-5p - %m"
            }
        }
    ],
    levels: {
        'test-logger': "DEBUG"
    },
    replaceConsole: true
});
var logger = log4js.getLogger('test-logger')

exports.LOG = logger
