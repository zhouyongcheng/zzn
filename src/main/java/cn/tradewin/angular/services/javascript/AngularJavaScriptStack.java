//
// Copyright 2010 GOT5 (GO Tapestry 5)
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// 	http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
package cn.tradewin.angular.services.javascript;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.services.AssetSource;
import org.apache.tapestry5.services.javascript.JavaScriptAggregationStrategy;
import org.apache.tapestry5.services.javascript.JavaScriptStack;
import org.apache.tapestry5.services.javascript.StylesheetLink;

public class AngularJavaScriptStack implements JavaScriptStack {

	public static final String STACK_ID = "AngularStack";

	private final AssetSource assetSource;

	public AngularJavaScriptStack(final AssetSource assetSource) {
		this.assetSource = assetSource;
	}

	@Override
	public List<String> getStacks() {
		return Collections.emptyList();
	}

	@Override
	public List<Asset> getJavaScriptLibraries() {
		List<Asset> ret = new ArrayList<Asset>();
		ret.add(assetSource.getContextAsset("js/lib/angular.js", null));
		ret.add(assetSource.getContextAsset("js/lib/angular-route.js", null));
		ret.add(assetSource.getContextAsset("js/lib/angular-resource.js", null));
		return ret;
	}

	@Override
	public List<StylesheetLink> getStylesheets() {
		return Collections.emptyList();
	}

	@Override
	public List<String> getModules() {
		return Collections.emptyList();
	}

	@Override
	public JavaScriptAggregationStrategy getJavaScriptAggregationStrategy() {
		return JavaScriptAggregationStrategy.COMBINE_AND_MINIMIZE;
	}

	@Override
	public String getInitialization() {
		return null;
	}
}
