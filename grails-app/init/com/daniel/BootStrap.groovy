package com.daniel

class BootStrap {

    def grailsApplication

    def init = {
//        servletContext ->
//
//        grailsApplication.serviceClasses.each {
//            def isSecured = it.getPropertyValue('secureService')
//            if( isSecured ) {
//                // example of how to 'intercept' service classes.
//                it.metaClass.invokeMethod = { name, args ->
//                    println '''SECURE before $name'''
//                    UshasVO ushasVO = new UshasVO()
//                    ushasVO.status = 0
//                    ushasVO.code = 2
//                    render ushasVO as grails.converters.JSON
//                    return false
//                    def res = delegate.metaClass.getMetaMethod(name,args).invoke( delegate, args)
//                    println '''SECURE after $name. res=$res'''
//                    res
//                }
//            }
//        }
    }

    def destroy = {
    }
}
