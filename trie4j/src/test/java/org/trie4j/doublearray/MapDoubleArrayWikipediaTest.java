/*
 * Copyright 2014 Takao Nakaguchi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.trie4j.doublearray;

import java.io.OutputStreamWriter;

import org.trie4j.AbstractMapTrieWikipediaTest;
import org.trie4j.MapTrie;
import org.trie4j.Trie;

public class MapDoubleArrayWikipediaTest extends AbstractMapTrieWikipediaTest{
	@Override
	protected MapTrie<Integer> buildSecondTrie(MapTrie<Integer> firstTrie) {
		return new MapDoubleArray<Integer>(firstTrie);
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void afterVerification(Trie trie) throws Exception {
		super.afterVerification(trie);
		trie.dump(new OutputStreamWriter(System.out));
		DoubleArray da = (DoubleArray)((MapDoubleArray<Integer>)trie).getTrie();
		System.out.println("base.length: " + da.getBase().length);
		System.out.println("term.size: " + da.getTerm().size());
	}
}
