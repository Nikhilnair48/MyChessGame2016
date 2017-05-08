
/**
 * This Class definition make use of requireJS to provide a clean and simple way to split JavaScript class definitions
 * into separate files and avoid global namespace pollution.  http://requirejs.org/
 */
define('validators/TestMetaInfo',[],function () {
    // Forces the JavaScript engine into strict mode: http://tinyurl.com/2dondlh
    

    /**
     * Naming constructor with capital letter to differentiate with regular functions
     */
    function TestMetaInfo(testplanId, name, message, type, severity, recommendation) {
        // This first guard ensures that the callee has invoked our Class' constructor function
        // with the `new` keyword - failure to do this will result in the `this` keyword referring 
        // to the callee's scope (typically the window global) which will result in the following fields
        // (testplanId, msg, name, type, severity) leaking into the global namespace and not being set on this object.
        if (!(this instanceof TestMetaInfo)) {
            throw new TypeError("TestMetaInfo constructor cannot be called as a function.");
        }
        //TestPlanId e.g. 1.6.5a traces back to actual test case definition
        this.testplanId = testplanId;
        //test execution message
        this.message = message;
        if (recommendation) {
            //recommendation
            this.recommendation = recommendation;
        }
        //test name e.g. validateThreeWordInvocationName
        this.name = name;
        //Test type : functional, security
        this.type = type;
        //WARNING, ERROR
        this.severity = severity;
    }

    /**
     * All methods added to a Class' prototype are public (visible); they are able to 
     * access the properties and methods of the TestMetaInfo class via the `this` keyword.
     */
    TestMetaInfo.prototype = {
            /**
             * Whenever you replace an Object's Prototype, you need to repoint
             * the base Constructor back at the original constructor Function, 
             * otherwise `instanceof` calls will fail.
             */
            constructor: TestMetaInfo,

            getTestPlanId: function () {
                return this.testplanId;
            },

            getMessage: function () {
                return this.message;
            },

            getRecommendation: function () {
                return this.recommendation;    
            },

            getName: function () {
                return this.name;
            },

            getType: function () {
                return this.type;
            },

            getSeverity: function () {
                return this.severity;
            },

            toString: function() {
                return "[testplanId:" + this.testplanId + ",message:" + this.message + ",name:"
                + this.name + ",type:" + this.type + ",severity:" + this.severity + "]";
            }
    };

    // As mentioned up top, requireJS needs us to return a value - in this files case, we will return
    // a reference to the constructor function.
    return TestMetaInfo;
});

/**
 * This Class definition make use of requireJS to provide a clean and simple way to split JavaScript class definitions
 * into separate files and avoid global namespace pollution.  http://requirejs.org/
 */
define('validators/TestResult',[],function () {
    // Forces the JavaScript engine into strict mode: http://tinyurl.com/2dondlh
    

    /**
     * Naming constructor with capital letter to differentiate with regular functions
     */
    function TestResult(testMetaInfo, status, details) {
        // This first guard ensures that the callee has invoked our Class' constructor function
        // with the `new` keyword - failure to do this will result in the `this` keyword referring 
        // to the callee's scope (typically the window global) which will result in the following fields
        // (testplanId, msg, name, type, severity) leaking into the global namespace and not being set on this object.
        if (!(this instanceof TestResult)) {
            throw new TypeError("TestResult constructor cannot be called as a function.");
        }
        //testMetaInfo : TestPlanId e.g. 1.6.5a traces back to actual test case definition
        this.testMetaInfo = testMetaInfo;
        //test status
        this.status = status;
        //Detailed message
        this.details = details;
    }

    /**
     * All methods added to a Class' prototype are public (visible); they are able to 
     * access the properties and methods of the TestResult class via the `this` keyword.
     */
    TestResult.prototype = {
            /**
             * Whenever you replace an Object's Prototype, you need to repoint
             * the base Constructor back at the original constructor Function, 
             * otherwise `instanceof` calls will fail.
             */
            constructor: TestResult,

            getTestMetaInfo: function () {
                return this.testMetaInfo;
            },

            getStatus: function () {
                return this.status;
            },

            getDetails: function () {
                return this.details;
            },

            toString: function() {
                return "[testMetaInfo:" + this.testMetaInfo.toString() + ",status:" + this.status + ",details:" + this.details + "]";
            }
    };

    //As mentioned up top, requireJS needs us to return a value - in this files case, we will return
    //a reference to the constructor function.
    return TestResult;
});
/**
 * This Class definition make use of requireJS to provide a clean and simple way to split JavaScript class definitions
 * into separate files and avoid global namespace pollution.  http://requirejs.org/
 */
define('validators/Status',[],function () {
	return {
        PASS: "PASS",
        FAIL: "FAIL",
        UNDEFINED : "UNDEFINED"
    }
});
/**
 * This Class definition make use of requireJS to provide a clean and simple way to split JavaScript class definitions
 * into separate files and avoid global namespace pollution.  http://requirejs.org/
 */
define('validators/Severity',[],function () {
	return {
        ERROR: "ERROR",
        WARNING: "WARNING"
    }
});
/**
 * Translation keys definition
 */
define('validators/TranslationKeys',[],function () {
    return {
        INVOCATION_NAME_VALIDATE_WORD_COUNT_SHORT_MSG : "INVOCATION_NAME_VALIDATE_WORD_COUNT_SHORT_MSG",
        INVOCATION_NAME_VALIDATE_WORD_COUNT_DETAIL_MSG : "INVOCATION_NAME_VALIDATE_WORD_COUNT_DETAIL_MSG",
        INVOCATION_NAME_VALIDATE_ALPHABETS_AND_SPACES_SHORT_MSG : "INVOCATION_NAME_VALIDATE_ALPHABETS_AND_SPACES_SHORT_MSG",
        INVOCATION_NAME_VALIDATE_ALPHABETS_AND_SPACES_DETAILED_MSG : "INVOCATION_NAME_VALIDATE_ALPHABETS_AND_SPACES_DETAILED_MSG",
        INVOCATION_NAME_VALIDATE_RESERVED_WORDS_SHORT_MSG : "INVOCATION_NAME_VALIDATE_RESERVED_WORDS_SHORT_MSG",
        INVOCATION_NAME_VALIDATE_RESERVED_WORDS_DETAILED_MSG : "INVOCATION_NAME_VALIDATE_RESERVED_WORDS_DETAILED_MSG",
        INVOCATION_NAME_VALIDATE_LENGTH_SHORT_MSG : "INVOCATION_NAME_VALIDATE_LENGTH_SHORT_MSG",
        INVOCATION_NAME_VALIDATE_LENGTH_DETAILED_MSG : "INVOCATION_NAME_VALIDATE_LENGTH_DETAILED_MSG",

        EXAMPLE_PHRASE_VALIDATE_WAKE_WORD_AND_INVOCATION_NAME_SHORT_MSG : "EXAMPLE_PHRASE_VALIDATE_WAKE_WORD_AND_INVOCATION_NAME_SHORT_MSG",
        EXAMPLE_PHRASE_VALIDATE_WAKE_WORD_AND_INVOCATION_NAME_DETAILED_MSG : "EXAMPLE_PHRASE_VALIDATE_WAKE_WORD_AND_INVOCATION_NAME_DETAILED_MSG",
        EXAMPLE_PHRASE_VALIDATE_INVOCATION_NAME_SHORT_MSG : "EXAMPLE_PHRASE_VALIDATE_INVOCATION_NAME_SHORT_MSG",
        EXAMPLE_PHRASE_VALIDATE_INVOCATION_NAME_DETAILED_MSG : "EXAMPLE_PHRASE_VALIDATE_INVOCATION_NAME_DETAILED_MSG",

        EXAMPLE_PHRASE_VALIDATE_EMOTICONS_AND_SYMBOLS_SHORT_MSG : "EXAMPLE_PHRASE_VALIDATE_EMOTICONS_AND_SYMBOLS_SHORT_MSG",
        EXAMPLE_PHRASE_VALIDATE_EMOTICONS_AND_SYMBOLS_DETAILED_MSG : "EXAMPLE_PHRASE_VALIDATE_EMOTICONS_AND_SYMBOLS_DETAILED_MSG",
        EXAMPLE_PHRASE_RECOMMENDATION_MSG : "EXAMPLE_PHRASE_RECOMMENDATION_MSG",
        
        INTENT_VALIDATE_INTENT_WITH_SAMPLE_UTTERANCES_SHORT_MSG : "INTENT_VALIDATE_INTENT_WITH_SAMPLE_UTTERANCES_SHORT_MSG",
        INTENT_VALIDATE_INTENT_WITH_SAMPLE_UTTERANCES_DETAILED_MSG : "INTENT_VALIDATE_INTENT_WITH_SAMPLE_UTTERANCES_DETAILED_MSG",
        
        INTENT_VALIDATE_INTENT_WITH_SLOTS_USED_IN_UTTERANCE_SHORT_MSG : "INTENT_VALIDATE_INTENT_WITH_SLOTS_USED_IN_UTTERANCE_SHORT_MSG",
        INTENT_VALIDATE_INTENT_WITH_SLOTS_USED_IN_UTTERANCE_DETAILED_MSG : "INTENT_VALIDATE_INTENT_WITH_SLOTS_USED_IN_UTTERANCE_DETAILED_MSG"

    }
});
define('validators/Translation_en',["validators/TranslationKeys"], function (TranslationKeys) {
	var translations = {
			INVOCATION_NAME_VALIDATE_WORD_COUNT_SHORT_MSG : "Should be shorter than or equal to 3 words",
			INVOCATION_NAME_VALIDATE_WORD_COUNT_DETAIL_MSG : "",
			INVOCATION_NAME_VALIDATE_ALPHABETS_AND_SPACES_SHORT_MSG : "No numeric, special characters, or punctuation. Note that possessive apostrophes & periods used in abbreviations are allowed.",
			INVOCATION_NAME_VALIDATE_ALPHABETS_AND_SPACES_DETAILED_MSG : "The 'Invocation Name' provided doesn't meet our guidelines. Please ensure that it doesn't contain digits, symbols or punctuation marks other than the possessive apostrophes (e.g., Mary’s Skill), or periods in abbreviations (e.g., A.B.C). To represent numbers, consider spelling them out(e.g., Nineteen Eighty Four).",
			INVOCATION_NAME_VALIDATE_RESERVED_WORDS_SHORT_MSG : "Does not contain ‘Alexa’, 'Echo' or ‘Amazon’",
			INVOCATION_NAME_VALIDATE_RESERVED_WORDS_DETAILED_MSG : "The 'Invocation Name' provided doesn't meet our guidelines. Please ensure that it doesn't contain the words 'Alexa', 'Echo' or 'Amazon'.",
			INVOCATION_NAME_VALIDATE_LENGTH_SHORT_MSG : "Should be between 2 - 50 characters",
			INVOCATION_NAME_VALIDATE_LENGTH_DETAILED_MSG : "The 'Invocation Name' provided doesn't meet our guidelines. Please ensure that it has at least 2 characters and at most 50 characters, forming a legitimate word that can be spoken by the user.",
			EXAMPLE_PHRASE_VALIDATE_WAKE_WORD_AND_INVOCATION_NAME_SHORT_MSG : "First Example Phrase should include the wake word ‘Alexa’",
			EXAMPLE_PHRASE_VALIDATE_WAKE_WORD_AND_INVOCATION_NAME_DETAILED_MSG : "The 'Example Phrase' provided doesn't meet our guidelines. Please ensure that the first phrase contains the wake word 'Alexa' and invocation name. Example: 'Alexa, ask Greeter to say hello world'.",
			EXAMPLE_PHRASE_VALIDATE_EMOTICONS_AND_SYMBOLS_SHORT_MSG : "Free of emoticons, special characters, or symbols",
			EXAMPLE_PHRASE_VALIDATE_EMOTICONS_AND_SYMBOLS_DETAILED_MSG : "The 'Example Phrase' provided doesn't meet our guidelines. Please ensure that it doesn't contain any emoticons, special characters, symbols, or grammatical errors.",
			EXAMPLE_PHRASE_RECOMMENDATION_MSG : "Include your invocation name in your phrases. For example, 'Alexa, ask Greeter to say hello world'",
			EXAMPLE_PHRASE_VALIDATE_INVOCATION_NAME_SHORT_MSG : "Include your invocation name in your phrases. For example, 'Alexa, ask Greeter to say hello world'",
			EXAMPLE_PHRASE_VALIDATE_INVOCATION_NAME_DETAILED_MSG : "Include your invocation name in your phrases. For example, 'Alexa, ask Greeter to say hello world'",
			INTENT_VALIDATE_INTENT_WITH_SAMPLE_UTTERANCES_SHORT_MSG : "Each non amazon intent must have atleast one sample utterance",
			INTENT_VALIDATE_INTENT_WITH_SAMPLE_UTTERANCES_DETAILED_MSG : "Please include atleast one sample utterance with each non amazon intent",
				INTENT_VALIDATE_INTENT_WITH_SLOTS_USED_IN_UTTERANCE_SHORT_MSG : "All defined slots must be used in atleast one sample utterance for that intent",
				INTENT_VALIDATE_INTENT_WITH_SLOTS_USED_IN_UTTERANCE_DETAILED_MSG : "Please include slots defined in each intent in one of the sample utterance for that intent"


	};

	var get = function(key) {
		return translations[key];
	};

	return {
		get : get
	};
});
/**
 * This Class definition make use of requireJS to provide a clean and simple way to split JavaScript class definitions
 * into separate files and avoid global namespace pollution.  http://requirejs.org/
 */
define('validators/LocalizedMessageResolver',["validators/Translation_en"], function (EnglishTranslation) {
    
    var translator = EnglishTranslation;

    var init = function(locale) {
        if (locale) {
            if (locale === "en") {
                translator = EnglishTranslation;
            }
        } 
    };

    var get = function(key) {
        return translator.get(key);
    };

    return {
        init : init,
        get : get
    };
});
/**
 * Constant definition
 */
define('validators/Constants',[],function () {
    return {
        INVOCATION_NAME_VALIDATE_WORD_COUNT_TEST_PLAN_ID : "1.6.5a",
        INVOCATION_NAME_VALIDATE_WORD_COUNT_TEST_NAME : "validateWordCount",

        INVOCATION_NAME_VALIDATE_ALPHABETS_AND_SPACES_TEST_PLAN_ID : "1.6.5c",
        INVOCATION_NAME_VALIDATE_ALPHABETS_AND_SPACES_TEST_NAME : "validateAlphabetsAndSpaces",

        INVOCATION_NAME_VALIDATE_RESERVED_WORDS_TEST_PLAN_ID : "1.6.5f",
        INVOCATION_NAME_VALIDATE_RESERVED_WORDS_TEST_NAME : "validateReservedWords",

        INVOCATION_NAME_VALIDATE_LENGTH_TEST_PLAN_ID : "1.6.5g",
        INVOCATION_NAME_VALIDATE_LENGTH_TEST_NAME : "validateLength",

        EXAMPLE_PHRASE_VALIDATE_WAKE_WORD_INVOCATION_NAME_TEST_PLAN_ID : "1.6.8a",
        EXAMPLE_PHRASE_VALIDATE_WAKE_WORD_INVOCATION_NAME_TEST_NAME : "validateWakeWordWithInvocationName",

        EXAMPLE_PHRASE_VALIDATE_INVOCATION_NAME_TEST_PLAN_ID : "1.6.8c",
        EXAMPLE_PHRASE_VALIDATE_INVOCATION_NAME_TEST_NAME : "validateInvocationName",

        EXAMPLE_PHRASE_VALIDATE_EMOTICONS_TEST_PLAN_ID : "1.6.8b",
        EXAMPLE_PHRASE_VALIDATE_EMOTICONS_TEST_NAME : "validateEmoticonsAndSymbols",
        
        INTENT_VALIDATE_INTENT_WITH_SAMPLE_UTTERANCES_TEST_PLAN_ID : "1.6.9a",
         INTENT_VALIDATE_INTENT_WITH_SAMPLE_UTTERANCES_TEST_PLAN_NAME : "validateIntentWithSampleUtterance",
         
         INTENT_VALIDATE_INTENT_WITH_SLOTS_USED_IN_UTTERANCE_TEST_PLAN_ID : "1.6.9b",
         INTENT_VALIDATE_INTENT_WITH_SLOTS_USED_IN_UTTERANCE_TEST_PLAN_NAME : "validateIntentWithSlotsUsedInUtterance",
    
        TEST_TYPE_FUNCTIONAL : "functional"
    }
});
define('validators/invocationNameValidator',["validators/TestMetaInfo", "validators/TestResult", "validators/Status", "validators/Severity", "validators/LocalizedMessageResolver", "validators/TranslationKeys", "validators/Constants"],
        function(TestMetaInfo, TestResult, Status, Severity, LocalizedMessageResolver, TranslationKeys, Constants) {

    var validateWordCountTest;
    var validateAlphabetsAndSpacesTest;
    var validateReservedWordsTest;
    var validateLengthTest;
    var ALEXA_WAKE_WORD = ["Alexa","Amazon", "Echo"];
    var ALEXA_LAUNCH_WORD = ["Ask", "Tell", "Talk to","Open", "Launch", "Start","Resume", "Run","Load","Begin","Play"];
                          
    var init = function(locale) {
        LocalizedMessageResolver.init(locale);
       
        validateWordCountTest = new TestMetaInfo(Constants.INVOCATION_NAME_VALIDATE_WORD_COUNT_TEST_PLAN_ID,
                Constants.INVOCATION_NAME_VALIDATE_WORD_COUNT_TEST_NAME,
                LocalizedMessageResolver.get(TranslationKeys.INVOCATION_NAME_VALIDATE_WORD_COUNT_SHORT_MSG),
                Constants.TEST_TYPE_FUNCTIONAL,
                Severity.WARNING);

        validateAlphabetsAndSpacesTest =  new TestMetaInfo(Constants.INVOCATION_NAME_VALIDATE_ALPHABETS_AND_SPACES_TEST_PLAN_ID,
                Constants.INVOCATION_NAME_VALIDATE_ALPHABETS_AND_SPACES_TEST_NAME,
                LocalizedMessageResolver.get(TranslationKeys.INVOCATION_NAME_VALIDATE_ALPHABETS_AND_SPACES_SHORT_MSG),
                Constants.TEST_TYPE_FUNCTIONAL,
                Severity.ERROR);
        validateReservedWordsTest = new TestMetaInfo(Constants.INVOCATION_NAME_VALIDATE_RESERVED_WORDS_TEST_PLAN_ID,
                Constants.INVOCATION_NAME_VALIDATE_RESERVED_WORDS_TEST_NAME,
                LocalizedMessageResolver.get(TranslationKeys.INVOCATION_NAME_VALIDATE_RESERVED_WORDS_SHORT_MSG),
                Constants.TEST_TYPE_FUNCTIONAL,
                Severity.ERROR);
        validateLengthTest = new TestMetaInfo(Constants.INVOCATION_NAME_VALIDATE_LENGTH_TEST_PLAN_ID,
                Constants.INVOCATION_NAME_VALIDATE_LENGTH_TEST_NAME,
                LocalizedMessageResolver.get(TranslationKeys.INVOCATION_NAME_VALIDATE_LENGTH_SHORT_MSG),
                Constants.TEST_TYPE_FUNCTIONAL,
                Severity.ERROR);
    };

    /**
     * function to validate word count
     * @param invocationName
     */

    var validateWordCount = function (invocationName) {
        if (!invocationName) {
            return new TestResult(validateWordCountTest, Status.UNDEFINED);
        }

        try {
            var str = invocationName.trim();
            var matches = str.match(/[a-z']+/gi); //matches the front and the back
            if ( matches) {
                matches = matches.map( function(f) {return f.length;});
                var count = 1;

                matches.reduce( function(prev, current) {
                    if ( prev !== 1 || current !== 1) {
                         count += 1;
                    }
                    return current;
                });

    //            var regex = /\S+/g;
    //            var wordCount = invocationName.match(regex).length;

                if (count > 3) {
                    return new TestResult(validateWordCountTest, Status.FAIL,
                            LocalizedMessageResolver.get(TranslationKeys.INVOCATION_NAME_VALIDATE_WORD_COUNT_DETAIL_MSG));
                }
            }
            return new TestResult(validateWordCountTest,Status.PASS);
        } catch (err) {
            return new TestResult(validateWordCountTest, Status.UNDEFINED);
        }
    };

    /**
     * validates valid chars allowed in the invocation name
     * i.e. only alphabets, spaces, apostrephe and periods
     */
    var validateAlphabetsAndSpaces = function (invocationName) {
        if (!invocationName) {
            return new TestResult(validateAlphabetsAndSpacesTest, Status.UNDEFINED);
        }
        try {
            var regex =/[^a-zA-Z\s\.\']/;
            if (regex.test(invocationName)) {
                return new TestResult(validateAlphabetsAndSpacesTest, Status.FAIL,
                        LocalizedMessageResolver.get(TranslationKeys.INVOCATION_NAME_VALIDATE_ALPHABETS_AND_SPACES_DETAILED_MSG));
            }
            return new TestResult(validateAlphabetsAndSpacesTest,Status.PASS);
        } catch (err) {
            return new TestResult(validateAlphabetsAndSpacesTest, Status.UNDEFINED);
        }
    };

    /**
     * invocation name must have atleast 2 charcters and at most 50 characters.
     */
    var validateLength = function (invocationName) {
         if (!invocationName) {
             return new TestResult(validateLengthTest, Status.UNDEFINED);
         }
         try {
             if (invocationName.length < 2 || invocationName.length > 50) {
                 return new TestResult(validateLengthTest, Status.FAIL,
                         LocalizedMessageResolver.get(TranslationKeys.INVOCATION_NAME_VALIDATE_LENGTH_DETAILED_MSG));
             }
             return new TestResult(validateLengthTest, Status.PASS);
         } catch (err) {
             return new TestResult(validateLengthTest, Status.UNDEFINED);
         }
    };

    /**
     * validates Alexa, Amazon, Echo, Ask, Tell, Talk to, Open, Launch, Start, Resume, Run, Load, Begin and Play words does not come in the invocation name
     */
    var validateReservedWords = function(invocationName) {
        if (!invocationName) {
            return new TestResult(validateReservedWordsTest, Status.UNDEFINED);
        }
        try {
        	var alexaWakeWordRegex = ALEXA_WAKE_WORD.join('|');
        	var alexaLaunchWordRegex = ALEXA_LAUNCH_WORD.join('|');
            var regex =  new RegExp("(\\w*\\s+|^)("+alexaWakeWordRegex+"|"+alexaLaunchWordRegex+")(\\s+\\w*|$)", "i");
            if (regex.test(invocationName)) {
                return new TestResult(validateReservedWordsTest, Status.FAIL,
                        LocalizedMessageResolver.get(TranslationKeys.INVOCATION_NAME_VALIDATE_RESERVED_WORDS_DETAILED_MSG));
            }
            return new TestResult(validateReservedWordsTest,Status.PASS);
        } catch (err) {
            return new TestResult(validateReservedWordsTest, Status.UNDEFINED);
        }
    };

    return {
        validateWordCount : validateWordCount,
        validateLength : validateLength,
        validateAlphabetsAndSpaces : validateAlphabetsAndSpaces,
        validateReservedWords : validateReservedWords,
        init : init
    };
});
define('validators/examplePhraseValidator',["validators/TestMetaInfo", "validators/TestResult", "validators/Status", "validators/Severity",
        "validators/LocalizedMessageResolver", "validators/TranslationKeys", "validators/Constants"],
        function(TestMetaInfo, TestResult, Status, Severity, LocalizedMessageResolver, TranslationKeys, Constants) {

    var validateWakeWordWithInvocationNameTest;
    var validateInvocationNameTest;
    var validateEmoticonsAndSymbolsTest;

    var init = function(locale) {
        LocalizedMessageResolver.init(locale);
        validateWakeWordWithInvocationNameTest = new TestMetaInfo(
                Constants.EXAMPLE_PHRASE_VALIDATE_WAKE_WORD_INVOCATION_NAME_TEST_PLAN_ID,
                Constants.EXAMPLE_PHRASE_VALIDATE_WAKE_WORD_INVOCATION_NAME_TEST_NAME,
                LocalizedMessageResolver.get(TranslationKeys.EXAMPLE_PHRASE_VALIDATE_WAKE_WORD_AND_INVOCATION_NAME_SHORT_MSG),
                Constants.TEST_TYPE_FUNCTIONAL,
                Severity.ERROR);

        validateInvocationNameTest = new TestMetaInfo(
                Constants.EXAMPLE_PHRASE_VALIDATE_INVOCATION_NAME_TEST_PLAN_ID,
                Constants.EXAMPLE_PHRASE_VALIDATE_INVOCATION_NAME_TEST_NAME,
                LocalizedMessageResolver.get(TranslationKeys.EXAMPLE_PHRASE_VALIDATE_INVOCATION_NAME_SHORT_MSG),
                Constants.TEST_TYPE_FUNCTIONAL,
                Severity.WARNING,
                LocalizedMessageResolver.get(TranslationKeys.EXAMPLE_PHRASE_RECOMMENDATION_MSG));

        validateEmoticonsAndSymbolsTest =  new TestMetaInfo(
                Constants.EXAMPLE_PHRASE_VALIDATE_EMOTICONS_TEST_PLAN_ID,
                Constants.EXAMPLE_PHRASE_VALIDATE_EMOTICONS_TEST_NAME,
                LocalizedMessageResolver.get(TranslationKeys.EXAMPLE_PHRASE_VALIDATE_EMOTICONS_AND_SYMBOLS_SHORT_MSG),
                Constants.TEST_TYPE_FUNCTIONAL,
                Severity.ERROR);
    };

    //remove the quotes in the beginning and the end
    function trimQuotes( str) {
        if (str) {
            str = str.replace(/(^\"|^'|\'$|\"$)/gi, "");
        }
        return str;
    }

    var validateWakeWordWithInvocationName = function (examplePhrase, invocationName) {
        if (!examplePhrase || !invocationName) {
            return new TestResult(validateWakeWordWithInvocationNameTest, Status.UNDEFINED);
        }
        examplePhrase = trimQuotes(examplePhrase);
        var regex =  new RegExp( "^(Alexa|Amazon|Echo)\\W.*", "i");
        if ( !regex.test( examplePhrase)) {
            return new TestResult(validateWakeWordWithInvocationNameTest, Status.FAIL,
                    LocalizedMessageResolver.get(TranslationKeys.EXAMPLE_PHRASE_VALIDATE_WAKE_WORD_AND_INVOCATION_NAME_DETAILED_MSG));   
        }
    
        /*var wakeRegex = new RegExp( "^.*(Alexa|Amazon|Echo).*", "i");
        if (!examplePhrase.match(wakeRegex)) {
            return new TestResult(validateWakeWordWithInvocationNameTest, Status.FAIL,
                    LocalizedMessageResolver.get(TranslationKeys.EXAMPLE_PHRASE_VALIDATE_WAKE_WORD_AND_INVOCATION_NAME_DETAILED_MSG));
        }*/
        return new TestResult(validateWakeWordWithInvocationNameTest, Status.PASS);
    };

    var validateInvocationName = function (examplePhrase, invocationName) {
        if (!examplePhrase || !invocationName) {
            return new TestResult(validateInvocationNameTest, Status.UNDEFINED);
        }

        invocationName = invocationName.replace(/\s+/gi, ' ').trim(); //clean up
        examplePhrase = examplePhrase.replace(/\s+/gi, ' ').trim();
        examplePhrase = examplePhrase.replace( /(Alexa|Amazon|Echo)[\,\s]+/gi, '');
        examplePhrase = trimQuotes(examplePhrase);

        var regex = new RegExp("(\\W|^)" + invocationName + "(\\W$|$|\\W.*$)", "gi");
        //var regex = new RegExp(".*\\W" + invocationName + "(\\W$|$|\\W.*$)", "gi");
        if ( !regex.test( examplePhrase)) {
            return new TestResult(validateInvocationNameTest, Status.FAIL,
                    LocalizedMessageResolver.get(TranslationKeys.EXAMPLE_PHRASE_VALIDATE_INVOCATION_NAME_DETAILED_MSG));
        }
        return new TestResult(validateInvocationNameTest, Status.PASS);
    };

    var validateEmoticonsAndSymbols = function (examplePhrase) {
        if (!examplePhrase) {
            return new TestResult(validateEmoticonsAndSymbolsTest, Status.UNDEFINED);
        }

        //All emoticons has either ':' or '<' or '>', so not allowing these characters
//        if (examplePhrase.match(/[:<>~!@#$%^&*\(\)\{\}\[\]\"\\\/-_=+]/)) {
//    if (examplePhrase.match(/[:<>]/) || examplePhrase.match(/[~!@#$%^&*\(\)\{\}\[\]\"\|\\\-_=+\/;\?]/)) {
        var regex = /[^a-zA-Z\s\.0-9\?!'\.\,\"\-\|\:\;\%\&\$\#\(\)\+\<\>\/\@]/;
        if (regex.test(examplePhrase)) {
            return new TestResult(validateEmoticonsAndSymbolsTest, Status.FAIL,
                    LocalizedMessageResolver.get(TranslationKeys.EXAMPLE_PHRASE_VALIDATE_EMOTICONS_AND_SYMBOLS_DETAILED_MSG));
        }
        return new TestResult(validateEmoticonsAndSymbolsTest, Status.PASS);
    };

    return {
        validateWakeWordWithInvocationName : validateWakeWordWithInvocationName,
        validateEmoticonsAndSymbols : validateEmoticonsAndSymbols,
        validateInvocationName : validateInvocationName,
        init : init
    };
});
define('validators/Parser',[],function () {

	/**
	 * entry function to get all custom intents 
	 * @param intent Schema string
	 * @param customIntentFlag: true for custom intents,  false for all intents
	 * @returns array of intents
	 */
	var getIntents = function( intentSchema, customIntentFlag) {

		var intentArray = intentSchema.intents;
		var intents = [];
		intents = intentArray.filter( function( element) {

			return ( !customIntentFlag || element.intent.toLowerCase().indexOf( "amazon.") < 0)

		}).map( function( element) {
			return element.intent;
		})

		return intents;
	}

	return {
		getIntents : getIntents
	};
}) ;

define('validators/Utils',['validators/Parser'],function ( Parser) {
	/**
	 * entry function to get mapping of intent to sample utterances
	 * @param intent Schema string
	 * @param sample utterances string
	 * @returns array of objects containing intent along with their array of sample utterances.
	 */
	var getIntentSampleUtterancesMapping = function( intentSchema, sampleUtteranceArray) {

		var customIntents = Parser.getIntents( intentSchema, true);
		var intentUtteranceArray = {};
		sampleUtteranceArray.forEach( function( sampleUtteranceElement) {
			var tempIntent = sampleUtteranceElement.substring( 0,sampleUtteranceElement.indexOf(' '));// extraction of corresponding intents from each line
			if( !intentUtteranceArray[tempIntent]) {
				intentUtteranceArray[tempIntent] = [];
			}
			var utterance = sampleUtteranceElement.substring( sampleUtteranceElement.indexOf(' ')).trim();
			intentUtteranceArray[tempIntent].push( utterance);
		})
		return intentUtteranceArray;
	}

	/**
	 * entry function to get mapping of intent to slots
	 * @param intent Schema string
	 * @param cutomIntentSlotFlag : true if custom intents required, false if all intents required
	 * @returns array of objects containing intent along with their array of slots.
	 */

	var getIntentSlotMapping = function( intentSchema, customIntentSlotFlag) {

		var intentArray = intentSchema.intents;
		var intentSlot =  {};
		var intentSlotObject = intentArray.filter( function( element) {

			return ( !customIntentSlotFlag || element.intent.toLowerCase().indexOf( "amazon.") < 0)
		})

		intentSlotObject.forEach( function( element) {
			var tempSlots = getSlotsForIntent( element);
			intentSlot[element.intent] = tempSlots;
		})

		return intentSlot;
	}


	/* used by getIntentSlotMapping function*/
	var getSlotsForIntent = function( obj) {

		if( obj.slots){
			slotsArray = obj.slots;
		}

		var tempSlots = [];
		slotsArray.forEach( function( slotValue) {
			tempSlots.push( slotValue.name);
		})	

		return tempSlots;
	}

//	method to extract slot id from sample utterance.
	var getSlotIDFromUtterance = function ( sampleUtterance) {
		var slotArray = [];
		tempSlots = sampleUtterance.match( /\{(.*?)\}/gi);// to extract all slots in form {slot}
		if( tempSlots != null) {
			tempSlots.forEach( function( slotValue) {
				slotValue = slotValue.replace( /\{|\}/gi, '');// remove parenthesis
				var splitString = slotValue.split("|");

				if( splitString.length > 1) {
					slotArray.push( splitString[1]);
				}
				else {
					slotArray.push( slotValue);
				}
			})
		}

		return slotArray;
	}

	return {
		getIntentSampleUtterancesMapping : getIntentSampleUtterancesMapping,
		getIntentSlotMapping : getIntentSlotMapping,
		getSlotIDFromUtterance : getSlotIDFromUtterance
	};
}) ;
define('validators/intentValidator',["validators/TestMetaInfo", "validators/TestResult", "validators/Status", "validators/Severity",
        "validators/LocalizedMessageResolver", "validators/TranslationKeys", "validators/Constants", "validators/Utils", "validators/Parser"],
        function( TestMetaInfo, TestResult, Status, Severity, LocalizedMessageResolver, TranslationKeys, Constants, Utils, Parser ) {

	var validateIntentWithSampleUtteranceTest;
	var validateIntentWithSlotsUsedInUtteranceTest;

	var init = function( locale) {
		LocalizedMessageResolver.init( locale);
		validateIntentWithSampleUtteranceTest = new TestMetaInfo(
				Constants.INTENT_VALIDATE_INTENT_WITH_SAMPLE_UTTERANCES_TEST_PLAN_ID,
				Constants.INTENT_VALIDATE_INTENT_WITH_SAMPLE_UTTERANCES_TEST_PLAN_NAME,
				LocalizedMessageResolver.get(TranslationKeys.INTENT_VALIDATE_INTENT_WITH_SAMPLE_UTTERANCES_SHORT_MSG),
				Constants.TEST_TYPE_FUNCTIONAL,
				Severity.ERROR);

		validateIntentWithSlotsUsedInUtteranceTest = new TestMetaInfo(
				Constants.INTENT_VALIDATE_INTENT_WITH_SLOTS_USED_IN_UTTERANCE_TEST_PLAN_ID,
				Constants.INTENT_VALIDATE_INTENT_WITH_SLOTS_USED_IN_UTTERANCE_TEST_PLAN_NAME,
				LocalizedMessageResolver.get(TranslationKeys.INTENT_VALIDATE_INTENT_WITH_SLOTS_USED_IN_UTTERANCE_SHORT_MSG),
				Constants.TEST_TYPE_FUNCTIONAL,
				Severity.ERROR);
	};

	// method for validating if each custom intent have at least one sample utterance
	var validateIntentWithSampleUtterance = function( intentSchema, sampleUtterances) {

		var intentSampleUtteranceArray = Utils.getIntentSampleUtterancesMapping( intentSchema, sampleUtterances);
		var customIntentArray = Parser.getIntents( intentSchema, true);
		var flag = 1;
		customIntentArray.some( function( intentElement) {

			if( !intentSampleUtteranceArray[intentElement] || intentSampleUtteranceArray[intentElement].length == 0) {
				flag = 0;
			}
		})
		if( flag == 0){
			return new TestResult( validateIntentWithSampleUtteranceTest, Status.FAIL,
					LocalizedMessageResolver.get( TranslationKeys.INTENT_VALIDATE_INTENT_WITH_SAMPLE_UTTERANCES_DETAILED_MSG)); 
		}
		return new TestResult( validateIntentWithSampleUtteranceTest, Status.PASS); 

	} 

	// method for validating if all defined slots of an intent are used in at least one sample utterance for that intent 
	var validateIntentWithSlotsUsedInUtterance = function( intentSchema, sampleUtterances){

		var intentSampleUtteranceArray = Utils.getIntentSampleUtterancesMapping( intentSchema, sampleUtterances);
		var intentSlotArray = Utils.getIntentSlotMapping( intentSchema, true);
		var customIntentArray = Parser.getIntents( intentSchema, true);
		var flag = 1;
		customIntentArray.forEach( function( customIntentElement) {
			var slotsFromUtterances = [];
			var slotsFromIntent = [];
			slotsFromIntent  = intentSlotArray[customIntentElement];// getting all slots of an intent
			if( intentSampleUtteranceArray[customIntentElement]) {
				intentSampleUtteranceArray[customIntentElement].some( function( intentSampleUtteranceElement) {
					
					var currentUtterance = intentSampleUtteranceElement;
					var currentUtteranceSlots = Utils.getSlotIDFromUtterance( currentUtterance)

					currentUtteranceSlots.forEach( function( currentUtteranceSlotsElement) {
						if(slotsFromUtterances.indexOf( currentUtteranceSlotsElement) < 0) {
							slotsFromUtterances.push( currentUtteranceSlotsElement);
						}
					})

				})
			}

			slotsFromUtterances.sort();
			slotsFromIntent.sort();
			if( slotsFromIntent.toString().trim().localeCompare( slotsFromUtterances.toString().trim()) !== 0) {
				flag = 0;
			}
		})

		if( flag == 0){
			return new TestResult( validateIntentWithSlotsUsedInUtteranceTest, Status.FAIL,
					LocalizedMessageResolver.get( TranslationKeys.INTENT_VALIDATE_INTENT_WITH_SLOTS_USED_IN_UTTERANCE_DETAILED_MSG)); 
		}

		return new TestResult( validateIntentWithSlotsUsedInUtteranceTest, Status.PASS);  
	}
	return {
		validateIntentWithSampleUtterance : validateIntentWithSampleUtterance,
		validateIntentWithSlotsUsedInUtterance : validateIntentWithSlotsUsedInUtterance,
		init : init
	};
});


/**
 * This Class definition make use of requireJS to provide a clean and simple way to split JavaScript class definitions
 * into separate files and avoid global namespace pollution.  http://requirejs.org/
 * 
 * Encapsulates the TestResult objects.
 */
define('validators/TestResultSummary',[],function () {
	// Forces the JavaScript engine into strict mode: http://tinyurl.com/2dondlh
	

	/**
	 * Naming constructor with capital letter to differentiate with regular functions
	 */
	function TestResultSummary() {
		// This first guard ensures that the callee has invoked our Class' constructor function
		// with the `new` keyword - failure to do this will result in the `this` keyword referring 
		// to the callee's scope (typically the window global) which will result in the following fields
		// (testplanId, msg, name, type, severity) leaking into the global namespace and not being set on this object.
		if (!(this instanceof TestResultSummary)) {
			throw new TypeError("TestResultSummary constructor cannot be called as a function.");
		}

		//Array to contain all test results 
		this.testResults = [];
	}

	/**
	 * All methods added to a Class' prototype are public (visible); they are able to 
	 * access the properties and methods of the TestResultSummary class via the `this` keyword.
	 */
	TestResultSummary.prototype = {
			/**
			 * Whenever you replace an Object's Prototype, you need to repoint
			 * the base Constructor back at the original constructor Function, 
			 * otherwise `instanceof` calls will fail.
			 */
			constructor: TestResultSummary,

			/**
			 * function to filter the test results by severity e.g. WARNING, ERROR.
			 * if severity is undefined, it returns all
			 */
			getTestResult: function (severity) {
				if (!severity || this.testResults.length == 0) {
					return this.testResults;
				}
				return this.testResults.filter( function(x) { return x.getTestMetaInfo().getSeverity() === severity; });
			},

			/**
			 * function to add a TestResult to TestResultSummary
			 * returns if testResult is undefined or of some other type
			 */
			addTestResult: function (testResult) {
				if (!testResult) {
					return;
				}
				return this.testResults.push(testResult);
			},

			toString: function() {
				return "[testResultSummary:" + this.testResults.toString() + "]";
			}
	};

	//As mentioned up top, requireJS needs us to return a value - in this files case, we will return
	//a reference to the constructor function.
	return TestResultSummary;
});
/**
 * This Class definition make use of requireJS to provide a clean and simple way to split JavaScript class definitions
 * into separate files and avoid global namespace pollution.  http://requirejs.org/
 */

/**
 * Class to encapsulate the common parameters shared across the validations.
 */
define('validators/CommonTestParams',[],function () {
    // Forces the JavaScript engine into strict mode: http://tinyurl.com/2dondlh
    

    /**
     * Naming constructor with capital letter to differentiate with regular functions
     */
    function CommonTestParams(locale, metricsCallback) {
        // This first guard ensures that the callee has invoked our Class' constructor function
        // with the `new` keyword - failure to do this will result in the `this` keyword referring 
        // to the callee's scope (typically the window global) which will result in the following fields
        // (testplanId, msg, name, type, severity) leaking into the global namespace and not being set on this object.
        if (!(this instanceof CommonTestParams)) {
            throw new TypeError("CommonTestParams constructor cannot be called as a function.");
        }
        this.locale = locale;
        if (metricsCallback) {
            this.metricsCallback = metricsCallback;
        }
    }
    
    /**
     * All methods added to a Class' prototype are public (visible); they are able to 
     * access the properties and methods of the CommonTestParams class via the `this` keyword.
     */
    CommonTestParams.prototype = {
            /**
             * Whenever you replace an Object's Prototype, you need to repoint
             * the base Constructor back at the original constructor Function, 
             * otherwise `instanceof` calls will fail.
             */
            constructor: CommonTestParams,

            getLocale : function () {
                return this.locale;
            },

            getMetricsCallback: function () {
                return this.metricsCallback;
            },

            toString: function() {
                return "[locale:" + this.locale + "]";
            }
    };

    // As mentioned up top, requireJS needs us to return a value - in this files case, we will return
    // a reference to the constructor function.
    return CommonTestParams;
});

/**
 * This Class definition make use of requireJS to provide a clean and simple way to split JavaScript class definitions
 * into separate files and avoid global namespace pollution.  http://requirejs.org/
 */

/**
 * Entry class for the client to call validation on invocation name and example phrase
 */
define('alexaInlineValidator',["validators/invocationNameValidator", "validators/examplePhraseValidator", "validators/intentValidator","validators/TestResultSummary", "validators/CommonTestParams"],
		function(invocationNameValidator, examplePhraseValidator,intentValidator, TestResultSummary, CommonTestParams) {

	var commonParams = new CommonTestParams("en");

	var init = function(locale, metricsCallback) {
		if (locale && metricsCallback) {
			commonParams = new CommonTestParams(locale, metricsCallback);
			return;
		} else if (locale) {
			commonParams = new CommonTestParams(locale);
		} else if (metricsCallback) {
			commonParams = new CommonTestParams("en", metricsCallback);
		}
	};

	/**
	 * Common function to get the list of tests for invocation name and example phrase
	 */
	var getTestInfo = function(func, index) {
		return func(index);
	};

	/**
	 * entry function to validate invocation name
	 * @param invocationName
	 * @param locale
	 * @returns array of TestResult, if invocationName is blank the status of TestResult is undefined
	 */
	var validateInvocationName = function (invocationName) {

		var locale  = commonParams.getLocale();
		invocationNameValidator.init(locale);
		if (invocationName) {
			invocationName = invocationName.replace(/\s+/gi, " ").trim();
		}
		var wordCountValidationResult = invocationNameValidator.validateWordCount(invocationName);
		var charsValidationResult = invocationNameValidator.validateAlphabetsAndSpaces(invocationName);
		var reservedWordValidationResult = invocationNameValidator.validateReservedWords(invocationName);
		var lengthValidationResult = invocationNameValidator.validateLength(invocationName);

		var resultSummary = new TestResultSummary();
		resultSummary.addTestResult(charsValidationResult);
		resultSummary.addTestResult(reservedWordValidationResult);
		resultSummary.addTestResult(lengthValidationResult);
		resultSummary.addTestResult(wordCountValidationResult);

		return resultSummary;
	};

	/**
	 * Entry function to validate example phrase
	 * @param examplePhrase
	 * @param invocationName
	 * @param index : index for the text box
	 * @param locale
	 */
	var validateExamplePhrase = function (index, examplePhrase, invocationName) {
		var resultSummary = new TestResultSummary();
		var locale = commonParams.getLocale();
		examplePhraseValidator.init(locale);

		var validateInvocationNameResult;
		if (index == 0) {
			resultSummary.addTestResult(examplePhraseValidator.validateWakeWordWithInvocationName(examplePhrase, invocationName));
			validateInvocationNameResult = examplePhraseValidator.validateInvocationName(examplePhrase, invocationName);
		}
		resultSummary.addTestResult(examplePhraseValidator.validateEmoticonsAndSymbols(examplePhrase));
		if (validateInvocationNameResult) {
			resultSummary.addTestResult(validateInvocationNameResult);
		}
		return resultSummary;
	};

	/**
	 * Entry function to validate example phrase
	 * @param intentSchema
	 * @param sampleUtterances
	 */
	var validateIntent = function( intentSchema, sampleUtterances){
		var resultSummary = new TestResultSummary();
		var locale = commonParams.getLocale();
		intentValidator.init( locale);
		resultSummary.addTestResult( intentValidator.validateIntentWithSampleUtterance(intentSchema, sampleUtterances));
		resultSummary.addTestResult( intentValidator.validateIntentWithSlotsUsedInUtterance(intentSchema, sampleUtterances));
		return resultSummary;
	}

	return {
		validateInvocationName : validateInvocationName,
		validateExamplePhrase : validateExamplePhrase,
		validateIntent : validateIntent,
		getTestInfo : getTestInfo,
		init : init
	};
});
require.config({
	paths : {
		validators : "./validators"
	}

});

define('alexaInlineConfig',['alexaInlineValidator'], function(alexaInlineValidator) {

	return alexaInlineValidator;
});