package net.rvanasa.schoology.impl;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;
import org.scribe.model.Verb;

class OAuthSchoologyApi extends DefaultApi10a
{
	private final SchoologyResourceLocator resourceLocator;
	
	public OAuthSchoologyApi(SchoologyResourceLocator resourceLocator)
	{
		this.resourceLocator = resourceLocator;
	}
	
	public SchoologyResourceLocator getResourceLocator()
	{
		return resourceLocator;
	}
	
	@Override
	public String getRequestTokenEndpoint()
	{
		return getResourceLocator().getRequestURL("oauth/request_token");
	}
	
	@Override
	public String getAccessTokenEndpoint()
	{
		return getResourceLocator().getRequestURL("oauth/access_token");
	}
	
	@Override
	public String getAuthorizationUrl(Token token)
	{
		return getResourceLocator().getRequestURL("oauth/authorize?oauth_token=" + token);
	}
	
	@Override
	public Verb getRequestTokenVerb()
	{
		return Verb.GET;
	}
	
	@Override
	public Verb getAccessTokenVerb()
	{
		return Verb.GET;
	}
}
