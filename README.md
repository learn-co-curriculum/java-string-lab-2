# String Lab 2

## Learning Goals

- Use `String` methods to extract the text between the start and end tags an HTML element.

## Introduction

The starter project contains a class named `SubstringExtractor` with a
method `extractH1Content`.  The method attempts to extract from the
parameter string
the substring contained between the `<h1>` start tag and the `</h1>` end tag.
The method returns an empty string `""` if it can't find the start or end tag.

There are several errors in the code that you will fix in this lab.

## Task #0

Run the Junit `SubstringExtractorTest`.

The only test that passes is `test0`,
which checks that the empty string is returned when the start tag `<h1>` can't be found.
As you can see, the string passed into the `extractH1Content` method does not
contain the `<h1>` tag, so the test passes:

`assertEquals("", SubstringExtractor.extractH1Content("<body><p>Hello World</p></body>"));`

## Task #1

![task1 error](https://curriculum-content.s3.amazonaws.com/6676/java-mod2-strings/task1.png)

However, the `test1` method fails with the following exception message:

`java.lang.StringIndexOutOfBoundsException: begin 6, end -1, length 27`

Let's look at the string the `test1` method passes as a parameter into the `extractH1Content` method:

`assertEquals("", SubstringExtractor.extractH1Content("<body><h1>Greetings!</body>"));`

- There is a start tag `<h1>` but no end tag `</h1>`.
- Recall the `String` method [indexOf()](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html#indexOf(java.lang.String))
  returns the value `-1` if a substring can't be found.
- The `extractH1Content` method should return the empty string `""`;
  however, it attempts to extract a substring using indices '6' (the index of `<h1>`) and '-1' (the index of `</h1>`).

1. Edit the `extractH1Content` method to fix this issue.
   The method should return the empty string `""` if either the start or end tag is missing.
2. Run the Junit `SubstringExtractorTest` and confirm the `test0` and `test1` methods pass.

## Task #2

![task2 error](https://curriculum-content.s3.amazonaws.com/6676/java-mod2-strings/task2.png)

The `test2` method fails with the following message:

```text
Expected :Hello World
Actual   :<h1>Hello World
```

The substring currently returned from the `extractH1Content` method includes the
start tag `<h1>`.    Notice the last line of code in the method,
which extracts the substring using the index of the start and end tags:

`return str.substring(indexStart, indexEnd);`

1. Edit the `extractH1Content` method to fix this issue.
   The method should return the substring that starts **after** the `<h1>` tag.
   (Consider using the `length()` method of the string class,
   rather than manually counting the characters in the start tag `<h1>`.)
2. Run the Junit `SubstringExtractorTest` and confirm the `test0`, `test1`, and `test2` methods pass.

## Task #3

![task3 error](https://curriculum-content.s3.amazonaws.com/6676/java-mod2-strings/task3.png)

The `test3` method fails with the following exception message:

`java.lang.StringIndexOutOfBoundsException: begin 15, end 6, length 32`

Let's look at the string passed into `extractH1Content`.

`assertEquals("Howdy", SubstringExtractor.extractH1Content("<body></h1><h1>Howdy</h1></body>"));`

Notice there are two end tags `</h1>`.  The method found the index 15 of the start tag `<h1>`,
but unfortunately it found the index 6 of the first end tag `</h1>`.  We need the method
to look for the end tag that is located **after** the start tag.

Recall the `indexOf` method has two versions:

`public int indexOf(String str)`    
`public int indexOf(String str, int fromIndex)`

The second one lets you pass a second parameter that is  the index to start looking the string
passed as the first parameter.

1. Edit the `extractH1Content` method to fix this issue.
   The method should look for the end tag located **after** the start tag.
2. Run the Junit `SubstringExtractorTest` and confirm the `test0`, `test1`, `test2`, and `test3` methods pass.

## Task #4

![task4 error](https://curriculum-content.s3.amazonaws.com/6676/java-mod2-strings/task4.png)

The `test4` method fails with the following message:

```text
Expected :Greetings!
Actual   :
```

Let's look at the string passed into `extractH1Content`.

` assertEquals("Greetings!", SubstringExtractor.extractH1Content("<body><H1>Greetings!</H1></body>"));`

Notice the tags are uppercase `<H1>` and `</H1>`.
The `extractH1Content` method is looking for tags defined with lowercase letters.

While you could update the method to look for both lower and uppercase versions
of the tags, another approach is to create a lowercase version of the string passed
into the parameter and then look for the lowercase start and end tags in that version.

Recall the `String` class has a method to convert to lowercase:

`public String toLowerCase()`

Be careful, the method `extractH1Content` should to return the substring "Greetings!"
contained between the start and end tags from the **original** string passed through the parameter
`"<body><H1>Greetings!</H1></body>"`.

This means the `extractH1Content` method needs two strings, (1)
the original string passed as the parameter, and (2) a new string
that is a lowercase version of the parameter string.
Find the indices of the start and end tags in the lowercase version (2),
but extract the substring using those indices from the original parameter string (1).

1. Edit the `extractH1Content` method to fix this issue.
   The method should extract the substring between start and end h1 tags, regardless of case.
2. Run the Junit `SubstringExtractorTest` and confirm all test  methods pass.

![all tests pass](https://curriculum-content.s3.amazonaws.com/6676/java-mod2-strings/allwork.png)

Congratulations!

## Resources

- [Java 17 String](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html)
