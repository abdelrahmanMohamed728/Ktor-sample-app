<#-- @ftlvariable name="quote" type="com.example.models.quote" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>
            ${quote.title}
        </h3>
        <p>
            ${quote.body}
        </p>
        <hr>
        <p>
            <a href="/quotes/${quote.id}/edit">Edit quote</a>
        </p>
    </div>
</@layout.header>
