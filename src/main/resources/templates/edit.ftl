<#-- @ftlvariable name="quote" type="com.example.models.quote" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>Edit quote</h3>
        <form action="/quotes/${quote.id}" method="post">
            <p>
                <input type="text" name="title" value="${quote.title}">
            </p>
            <p>
                <textarea name="body">${quote.body}</textarea>
            </p>
            <p>
                <input type="submit" name="_action" value="update">
            </p>
        </form>
    </div>
    <div>
        <form action="/quotes/${quote.id}" method="post">
            <p>
                <input type="submit" name="_action" value="delete">
            </p>
        </form>
    </div>
</@layout.header>
