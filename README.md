# lavi-lisa-restapi

This is a set of RestFUL API endpoints enabling users to query and display verb conjugation and noun declension tables, aside with a dictionary with a small bunch of entries.

## /dic/entries/{entry}

Provides basic info about the specified {entry}, which must be in Lavi language. It'll bring Portuguese words and/or expressions as a result.

## /dic/parts-of-speech

List all the parts of speech supported by this dictionary.

## /verbs/{verb}

Returns a conjugation table.

You can even filter which tenses/modes/persons you want to rertrieve.

## /nouns/{noun}

Returns a declension table.

You can even filter them by case, plurality, or even person (for possessive forms of nominative).

