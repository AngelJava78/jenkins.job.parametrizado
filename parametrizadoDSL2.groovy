job('ejemplo3-job-DSL') {
	description('Job DSL de ejemplo para el curso de Jenkins')
  	scm {
      		git('https://github.com/AngelJava78/jenkins.job.parametrizado.git', 'main') { node ->
        		node / gitConfigName('AngelJava78')
        		node / gitConfigEmail('angel_java@hotmail.com')
      		}
    	} 
  	parameters {
		stringParam('nombre', defaultValue = 'Angel', description = 'Parametro de cadena para el Job Booleano')
		choiceParam('planeta', ['Mercurio', 'Venus', 'Tierrra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
		booleanParam('agente', false)
		stringParam('apellido', defaultValue = 'Javier', description= 'Apellido paterno' )
		stringParam('edad', defaultValue = '43', description= 'Edad' )
		stringParam('gender', defaultValue = 'M', description = 'Gender'
    }
  	triggers {
    		cron('H/3 * * * *')
        	githubPush()
    	}
  	steps {
    		shell("bash jobscript.sh")
    	}
  	publishers {
      		mailer('angel_java@hotmail.com', true, true)
      		slackNotifier {
		  notifyAborted(true)
		  notifyEveryFailure(true)
		  notifyNotBuilt(false)
		  notifyUnstable(false)
		  notifyBackToNormal(true)
		  notifySuccess(false)
		  notifyRepeatedFailure(false)
		  startNotification(false)
		  includeTestSummary(false)
		  includeCustomMessage(false)
		  customMessage(null)
		  sendAs(null)
		  commitInfoChoice('NONE')
		  teamDomain(null)
		  authToken(null)
        	}
    	}
}