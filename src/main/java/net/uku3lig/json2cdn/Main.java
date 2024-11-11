package net.uku3lig.json2cdn;

import net.dzikoysk.cdn.Cdn;
import net.dzikoysk.cdn.CdnException;
import net.dzikoysk.cdn.CdnFactory;
import net.dzikoysk.cdn.source.Source;
import panda.std.Result;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("usage: json2cdn [input file path]");
            System.exit(1);
        }

        final Cdn json = CdnFactory.createJsonLike();
        final Cdn cdn = CdnFactory.createStandard();
        final File file = new File(args[0]);

        final Result<String, CdnException> config = json.load(Source.of(file)).flatMap(cdn::render);

        if (config.isOk()) {
            System.out.println(config.get());
        } else {
            throw config.getError();
        }
    }
}
